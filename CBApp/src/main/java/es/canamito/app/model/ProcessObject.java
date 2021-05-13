package es.canamito.app.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase contenedor para alojar la respuesa del Proceso ejecutado
 * 
 * @author wkl
 * @version 0.1
 */
// TODO: Documentación
public class ProcessObject {

	private HttpServletRequest httpRequest;
	private HttpServletResponse httpResponse;
	private String viewPath;

	public ProcessObject(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String viewPath) {
		setHttpServletRequest(httpRequest);
		setHttpServletResponse(httpResponse);
		setViewPath(viewPath);
	}

	private void setHttpServletRequest(HttpServletRequest request) {
		this.httpRequest = request;
	}

	private void setHttpServletResponse(HttpServletResponse response) {
		this.httpResponse = response;
	}

	private void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	public HttpServletRequest getHttpServletRequest() {
		return this.httpRequest;
	}

	public HttpServletResponse getHttpServletResponse() {
		return this.httpResponse;
	}

	public String getViewPath() {
		return this.viewPath;
	}

}
