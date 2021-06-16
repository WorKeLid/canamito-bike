package es.canamito.app.controller.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.app.model.CBAttribute;
import es.canamito.app.model.CBAttribute.InputType;
import es.canamito.persistance.model.CBModel;
import es.canamito.persistance.model.CColumn;
import es.canamito.persistance.model.CProcess;
import es.canamito.persistance.model.CTable;

public class CBTDrawTableModel extends TagSupport implements TryCatchFinally {

	private static final Logger log = LogManager.getLogger();
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public int doStartTag() {
		int res = EVAL_BODY_INCLUDE;

		try {
			Map<CTable, List<CBModel>> table = new HashMap<CTable, List<CBModel>>();
			table = (Map<CTable, List<CBModel>>) pageContext.getRequest().getAttribute("table");

			CProcess process = (CProcess) pageContext.getRequest().getAttribute("process");

			if (!table.isEmpty()) {
				drawTable(table, process);
			} else {
				log.debug("table is empty");
			}
		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
			res = SKIP_BODY;
		}
		return res;
	}

	public int doAfterBody() {
		return 0;
	}

	public int doEndTag() {
		return 0;
	}

	public void doCatch(Throwable arg0) throws Throwable {
	}

	public void doFinally() {
	}

	private void drawTable(Map<CTable, List<CBModel>> table, CProcess process) throws IOException {
		JspWriter out = pageContext.getOut();

		for (Map.Entry<CTable, List<CBModel>> t : table.entrySet()) {
			// TODO: Ordenar Collections.sort(t.getValue());
			List<String> headerValue = new ArrayList<String>();

			out.println("<div class=\"border flex-container m-1\">");
			for (CColumn cc : t.getKey().getCColumns()) {
				out.println("<div><header class=\"m-1\">" + cc.getName() + "</header>" + "<div class=\"m-1\">"
						+ cc.getDescription() + "</div>" + "</div>");
				headerValue.add(cc.getName());
			}
			out.println("</div>");

			for (CBModel cbm : t.getValue()) {
				out.println("<form action=\"/CanamitoBike/app/" + process.getCMenus().get(0).getPath()
						+ "\" method=\"post\" class=\"border flex-container m-1\">");

				for (int i = 0; i <= cbm.getAttributes().size() - 1; i++) {

					CBAttribute col = cbm.getAttributes().get(i);

					out.println("<div>");

					out.println("<header class=\"m-1\">" + headerValue.get(i) + "</header>");

					if (col.getInputType().equals(InputType.id)) {
						out.println("<input class=\"input-sm m-1\"" + "type=\"number" + "\" " + "value=\""
								+ col.getValue() + "\"" + " name=\"inpid" + "\"" + ">");
					} else {
						out.println("<input class=\"input-sm m-1\"" + "type=\"" + col.getInputType() + "\" "
								+ "value=\"" + col.getValue() + "\" name=\"inp" + col.getInputName() + "\"" + ">");
					}
					out.println("</div>");

				}
				out.println("<button type=\"submit\" class=\"m-1 btn btn-primary\">Guardar</button>");

				out.println("</form>");
			}
		}
	}
}
