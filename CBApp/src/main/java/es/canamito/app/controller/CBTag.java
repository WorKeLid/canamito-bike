package es.canamito.app.controller;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 * Etiqueta usada por las vistas jsp
 * 
 * @author wkl
 * @version 0.1
 */
// TODO: Documentación
// TODO: Implementación
public class CBTag extends TagSupport implements TryCatchFinally {

	private static final long serialVersionUID = 1L;

	public int doStartTag() {

		int res = EVAL_BODY_INCLUDE;

		JspWriter out = pageContext.getOut();

		try {
			out.println("Saludos desde la etiqueta CBTag");
		} catch (Exception e) {
			// No va a evaluar el contenido del cuerpo de la etiqueta
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

}
