package es.canamito.app.controller.process;

import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBProcessImpl;

/**
 * Proceso para generar la página principal de CañamitoBike
 * 
 * @author wkl
 * @version 1.210515 - Documentación del proceso HomePage
 */
public class HomePage extends CBProcessImpl implements CBProcess {

	public HomePage() {
		super();
	}

	public void execute() throws Exception {
		log.trace("execute: " + this.getClass().getCanonicalName());

		// TODO: Por el momento no es necesario ninguna implementación

		log.trace("execute: viewing with " + getProcessDefaultView());
		getRequest().getRequestDispatcher(getProcessDefaultView()).forward(getRequest(), getResponse());
	}
}