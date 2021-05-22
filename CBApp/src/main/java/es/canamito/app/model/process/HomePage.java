package es.canamito.app.model.process;

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
		// TODO: Implementación

		this.setViewPath("/WEB-INF/jsp/es/canamito/app/view/process/HomePage.jsp");
		try {
			log.debug("executing to " + getViewPath());
			getRequest().getRequestDispatcher(getViewPath()).forward(getRequest(), getResponse());
		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
		}

	}
}