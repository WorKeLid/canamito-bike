package es.canamito.app.controller.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.app.model.CBMessage;

public class CBTConsumeCBMessage extends TagSupport implements TryCatchFinally {

	private static final Logger log = LogManager.getLogger();
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		int res = EVAL_BODY_INCLUDE;
		try {
			CBMessage msg = getCBMessage();
			if (msg != null) {
				displayCBMessage(msg);
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

	/**
	 * Busca el último mensaje CBMessage en la sesión, si lo encuentra, lo elimina
	 * de la sessión
	 * 
	 * @return El CBMessage de la sesión o null si no hay
	 */
	private CBMessage getCBMessage() {
		CBMessage res = null;
		Object msg = pageContext.getSession().getAttribute("msg");
		if (msg != null) {
			log.trace("message found for user");
			res = (CBMessage) msg;
			pageContext.getSession().removeAttribute("msg");
		} else {
			log.trace("no message for user");
		}
		return res;
	}

	/**
	 * Muestra el CBMessage al usuario
	 * 
	 * @param msg El CBMessage a mostrar
	 */
	private void displayCBMessage(CBMessage msg) {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<div class=\"alert alert-" + msg.getType() + " alert-dismissible fade show\" role=\"alert\">");
			out.println("<h4 class=\"alert-heading\">" + msg.getTitle() + "</h4>");
			out.println("<p>" + msg.getDescription() + "</p>");
			if (msg.getException() != null) {
				out.println("<hr>");
				out.println("<p class=\"mb-0\">" + msg.getException().getClass() + ": "
						+ msg.getException().getMessage() + "</p>");
			}
			out.println(
					"<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>");
			out.println("</div>");
		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
		}
	}
}