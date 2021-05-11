package es.canamito.app.controller;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

public class CBTag extends TagSupport implements TryCatchFinally {

	private static final long serialVersionUID = 1L;

	public int doStartTag() {

		JspWriter out = pageContext.getOut();

		try {
			// TODO:
		} catch (Exception e) {
			// TODO:
		}

		// No va a evaluar el contenido del cuerpo de la etiqueta
		return SKIP_BODY;
	}

	public int doAfterBody() {
		// TODO:
		return 0;
	}

	public int doEndTag() {
// TODO: 
		return 0;
	}

	@Override
	public void doCatch(Throwable arg0) throws Throwable {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFinally() {
		// TODO Auto-generated method stub

	}

}
