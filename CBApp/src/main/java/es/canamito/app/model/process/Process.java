package es.canamito.app.model.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.canamito.app.model.ProcessObject;

/**
 * Interfaz para los procesos, ventanas e informes
 * 
 * @author wkl
 * @version 0.1
 */
// TODO: Documentación
public interface Process {

	HttpServletRequest getRequest();

	HttpServletResponse getResponse();

	String getViewPath();

	ProcessObject execute();
}
