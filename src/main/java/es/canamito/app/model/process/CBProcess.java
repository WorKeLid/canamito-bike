package es.canamito.app.model.process;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.canamito.persistance.model.CProcess;

/**
 * <div> Todo proceso, ventana o informe debe implementar esta interfaz para
 * ofrecer al controlador principal una respuesta a la peticion recibida<div>
 * 
 * @author wkl
 * @version 1.210515 - Documentacion e implementación de la interfaz
 */
public interface CBProcess {
	/**
	 * @return Devuelve el contexto en el que se ha ejecutado el controlador
	 *         principal
	 */
	ServletContext getServletContext();

	/**
	 * @return La peticion que ha recibido el controlador principal
	 */
	HttpServletRequest getRequest();

	/**
	 * @return La respuesta que ha recibido el controlador principal
	 */
	HttpServletResponse getResponse();

	/**
	 * @return Una referencia al proceso definido en la base de datos
	 */
	CProcess getCProcess();

	/**
	 * @return Devuelve la vista por defeco del proceso
	 */
	String getProcessDefaultView();

	/**
	 * @param servletContext Asigna el contexto en el que se está ejecutando el
	 *                       controlador principal
	 */
	void setServletContext(ServletContext servletContext);

	/**
	 * @param request Asigna una petición
	 */
	void setRequest(HttpServletRequest request);

	/**
	 * @param response Asigna una respuesta
	 */
	void setResponse(HttpServletResponse response);

	/**
	 * @param cProcess Asigna un proceso de la base de datos
	 */
	void setCProcess(CProcess cProcess);

	/**
	 * <div>Función que evalua la peticion y respuestas recibidas y genera una
	 * vista</div>
	 */
	void execute() throws Exception;
}
