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

	public void execute() {
		log.debug("executing " + this.getClass().getCanonicalName());

		// TODO: Implementación

		this.setViewPath("/WEB-INF/jsp/es/canamito/app/view/process/HomePage.jsp");
		try {
			log.debug("viewing with " + getViewPath());
			getRequest().getRequestDispatcher(getViewPath()).forward(getRequest(), getResponse());
		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
		}

	}
}