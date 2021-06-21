package es.canamito.app.controller.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Query;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.app.model.CBAttribute;
import es.canamito.app.model.CBAttribute.HTMLInputType;
import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CBWindowable;
import es.canamito.persistance.model.CColumn;
import es.canamito.persistance.model.CProcess;
import es.canamito.persistance.model.CTable;

/**
 * Etiqueta para dibujar procesos de tipo ventana
 * 
 * @author wkl
 * @version 1.210617 - Implementación y documentación inicial
 */
public class CBTDrawWindow extends TagSupport implements TryCatchFinally {

	private static final Logger log = LogManager.getLogger();
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public int doStartTag() {
		int res = EVAL_BODY_INCLUDE;

		try {
			Map<CTable, List<CBWindowable>> table = new HashMap<CTable, List<CBWindowable>>();
			table = (Map<CTable, List<CBWindowable>>) pageContext.getRequest().getAttribute("table");

			CProcess process = (CProcess) pageContext.getRequest().getAttribute("process");

			if (!table.isEmpty()) {
				drawTable(table, process);
			} else {
				log.debug("doStartTag: table is empty");
			}
		} catch (Exception e) {
			log.error("doStartTag: " + e.getClass() + ": " + e.getMessage());
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

	/**
	 * Dibuja el modelo recibido del proceso utilizando Bootstrap 5
	 * 
	 * @param table   Mapa con metadatos de la tabla y una lista con los registros
	 *                de la tabla
	 * @param process El proceso que ha solicitado dibujar la tabla
	 * @throws IOException
	 */
	private void drawTable(Map<CTable, List<CBWindowable>> table, CProcess process) throws IOException {
		JspWriter out = pageContext.getOut();

		for (Map.Entry<CTable, List<CBWindowable>> cTable : table.entrySet()) {

			Comparator<CBWindowable> comparator = (CBWindowable w1, CBWindowable w2) -> Integer
					.valueOf(w1.getId().getValue().toString())
					.compareTo(Integer.valueOf(w2.getId().getValue().toString()));
			Collections.sort(cTable.getValue(), comparator);

			out.println(
					"<form action=\"/CanamitoBike/app/" + process.getCMenus().get(0).getPath() + "\" method=\"post\"");
			out.println("<div class=\"modal-body\">");
			for (CColumn c : cTable.getKey().getCColumns()) {
				if (c.getInputType().equals("hidden")) {

				} else if (c.getInputType().equals("selector")) {
					out.println("<label for=\"" + c.getAttributeName() + "\" class=\"col-form-label\">");
					out.println(c.getName() + "</label>");
					out.println(
							"<select name=\"inp" + c.getAttributeName() + "\" class=\"selectpicker\" data-size=\"5\">");
					out.println("<option value=\"" + "\">" + "</option>");
					for (CBWindowable foreignEntitiy : getForeignEntities(c.getAttributeName())) {
						out.println("<option value=\"" + foreignEntitiy.getId().getValue() + "\">"
								+ foreignEntitiy.getIdentifier().getValue() + "</option>");
					}

					out.println("</select>");
				} else if (c.getInputType().equals("checkbox")) {
					out.println("<label for=\"" + c.getAttributeName() + "\" class=\"col-form-label\">");
					out.println(c.getName() + "</label>");
					out.println("<input class=\"input-sm\"" + "type=\"" + c.getInputType() + "\" " + "value=\""
							+ "\" name=\"inp" + c.getAttributeName() + "\"" + ">");
				} else {
					out.println("<div class=\"align-items-center\">");
					out.println("<label for=\"" + c.getAttributeName() + "\" class=\"col-form-label\">");
					out.println(c.getName() + "</label>");
					out.println("<input type=\"" + c.getInputType() + "\"" + " name=\"inp" + c.getAttributeName()
							+ "\" " + "class=\"form-control\">");
					out.println("</div>");
				}

			}
			out.println("<div class=\"modal-footer\">");
			out.println(
					"<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Cerrar</button>");
			out.println("<button type=\"submit\" class=\"btn btn-primary\">Crear</button>");
			out.println("</div>");
			out.println("</form></div></div></div>");

			for (CBWindowable cbm : cTable.getValue()) {
				out.println("<form action=\"/CanamitoBike/app/" + process.getCMenus().get(0).getPath()
						+ "\" method=\"post\" class=\"border-start flex-container\">");

				out.println("<div>");
				out.println("<input class=\"input-sm\"" + "type=\"hidden" + "\" " + "value=\"" + cbm.getId().getValue()
						+ "\"" + " name=\"inpid" + "\"" + ">");
				out.println("<pre>#" + cbm.getId().getValue() + "</pre>");
				out.println("</div>");

				for (int i = 0; i <= cbm.getAttributes().size() - 1; i++) {

					CBAttribute col = cbm.getAttributes().get(i);

					out.println("<div>");

					out.println("<header class=\"m-1\">" + getCColumn(cTable.getKey(), col).getName() + "</header>");

					if (col.getHTMLInputType().equals(HTMLInputType.selector)) {
						CBWindowable foreign = (CBWindowable) col.getValue();
						out.println("<select name=\"inp" + col.getInputName()
								+ "\" class=\"selectpicker\" data-size=\"5\">");

						if (foreign != null) {
							out.println("<option value=\"" + foreign.getId().getValue() + "\" selected>"
									+ foreign.getIdentifier().getValue() + "</option>");
						} else {
							out.println("<option value=\"" + "\" selected>" + "</option>");
						}
						out.println("<option value=\"" + "\">" + "</option>");
						for (CBWindowable foreignEntitiy : getForeignEntities(col.getInputName())) {
							out.println("<option value=\"" + foreignEntitiy.getId().getValue() + "\">"
									+ foreignEntitiy.getIdentifier().getValue() + "</option>");
						}

						out.println("</select>");
					} else if (col.getHTMLInputType().equals(HTMLInputType.checkbox)) {
						Boolean check = (Boolean) col.getValue();
						String aux = check.booleanValue() == true ? " checked" : "";
						out.println(
								"<input class=\"input-sm\"" + "type=\"" + col.getHTMLInputType() + "\" " + "value=\""
										+ col.getValue() + "\" name=\"inp" + col.getInputName() + "\"" + aux + ">");
					} else {
						out.println("<input class=\"input-sm\"" + "type=\"" + col.getHTMLInputType() + "\" "
								+ "value=\"" + col.getValue() + "\" name=\"inp" + col.getInputName() + "\"" + ">");
					}
					out.println("</div>");

				}
				out.println("<button type=\"submit\" class=\"btn btn-primary\">Guardar</button>");

				out.println("</form>");
			}
		}
	}

	private List<CBWindowable> getForeignEntities(String entity) {
		List<CBWindowable> res = new ArrayList<CBWindowable>();

		CBDal cbd = new CBDal();

		String sql = "SELECT p FROM " + entity + " p";
		Query q = cbd.getEntityManager().createQuery(sql);

		List<?> aux = q.getResultList();
		for (Object o : aux) {
			res.add((CBWindowable) o);
		}
		return res;
	}

	private CColumn getCColumn(CTable table, CBAttribute col) {
		return table.getCColumns().stream().filter(c -> c.getAttributeName().equals(col.getInputName()))
				.collect(Collectors.toList()).get(0);
	}
}

//out.println("<div class=\"border flex-container m-1\">");
//for (CColumn cc : cTable.getKey().getCColumns()) {
//	out.println("<div><header class=\"m-1\">" + cc.getName() + "</header>" + "<div class=\"m-1\">"
//			+ cc.getDescription() + "</div>" + "</div>");
//	headerValue.add(cc.getName());
//}
//out.println("</div>");

//out.println("<nav class=\"navbar navbar-default navbar-fixed-top\">");
//out.println("<div class=\"container\">");
//out.println("<div><header class=\"m-0 p-0\">" + "Identificador" + "</header>" + "<div class=\"m-1\">"
//		+ "Identificador único" + "</div>" + "</div>");
//for (CBAttribute aux : cTable.getValue().get(0).getAttributes()) {
//	CColumn cc = cTable.getKey().getCColumns().stream()
//			.filter(c -> c.getAttributeName().equals(aux.getInputName())).collect(Collectors.toList())
//			.get(0);
//	out.println("<div><header class=\"m-0 p-0\">" + cc.getName() + "</header>" + "<div class=\"m-1\">"
//			+ cc.getDescription() + "</div>" + "</div>");
//}

//out.println("</div>");
//out.println("</nav>");
