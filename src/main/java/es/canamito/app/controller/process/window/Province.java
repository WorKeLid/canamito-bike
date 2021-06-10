package es.canamito.app.controller.process.window;

import javax.servlet.http.HttpServletRequest;

import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBWindowImpl;

/**
 * Proceso ventana para mostrar información sobre las provincias
 * 
 * @author wkl
 *
 */
public class Province extends CBWindowImpl implements CBProcess {

	public Province() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
		getRequest().setAttribute("title", "Provincias y sus localidades");
	}
}
