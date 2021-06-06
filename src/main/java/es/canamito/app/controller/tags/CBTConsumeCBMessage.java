package es.canamito.app.controller.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

public class CBTConsumeCBMessage extends TagSupport implements TryCatchFinally {

	private static final long serialVersionUID = 1L;

	public int doStartTag() {

		int res = EVAL_BODY_INCLUDE;

		JspWriter out = pageContext.getOut();

		try {
			out.println("<pre>Saludos desde la etiqueta CBTConsumeCBMessage</pre>");
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
