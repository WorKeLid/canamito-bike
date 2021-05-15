package es.canamito.app.model.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <div> Todo proceso, ventana o informe debe implementar esta interfaz para
 * ofrecer al controlador principal una respuesta a la peticion recibida<div>
 * 
 * @author wkl
 * @version 1.210515 - Documentacion e implementación de la interfaz
 */
public interface CBProcess {

	/**
	 * @return La peticion que ha recibido el controlador principal
	 */
	HttpServletRequest getRequest();

	/**
	 * @return La respuesta que ha recibido el controlador principal
	 */
	HttpServletResponse getResponse();

	/**
	 * @return La ruta a la vista que ofrecerá la respuesta generada por el proceso
	 */
	String getViewPath();

	/**
	 * @param request Asigna una petición
	 */
	void setRequest(HttpServletRequest request);

	/**
	 * @param response Asigna una respuesta
	 */
	void setResponse(HttpServletResponse response);

	/**
	 * <div>Función que evalua la peticion y respuestas recibidas y genera una
	 * respuesta</div>
	 * 
	 * @return Un ProcessObject con la peticion, respuesta y resultado del proceso
	 */
	void execute();
}
