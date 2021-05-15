package es.canamito.app.model.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <div>Clase abstracta asigna la peticion y respuesta y deja la implementación
 * de su ejecucion a sus hijos</div>
 * 
 * @author wkl
 * @version 1.210515 - Documentacion e implementación de la clase abstracta
 */
public abstract class CBProcessImpl implements CBProcess {

	protected static final Logger log = LogManager.getLogger();

	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	private String viewPath;

	public CBProcessImpl() {

	}

	public HttpServletRequest getRequest() {
		return this.httpServletRequest;
	}

	public HttpServletResponse getResponse() {
		return this.httpServletResponse;
	}

	public String getViewPath() {
		return this.viewPath;
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

	}

	public void setResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	/**
	 * <div>Este método debe evaluar la petición y respuestas recibidas y generar
	 * una respuesta</div>
	 */
	public abstract void execute();

}
