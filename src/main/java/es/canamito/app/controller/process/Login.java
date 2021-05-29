package es.canamito.app.controller.process;

import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBProcessImpl;

/**
 * Proceso para ofrecer un ingreso de sesión
 * 
 * @author wkl
 *
 */
public class Login extends CBProcessImpl implements CBProcess {

	public Login() {
		super();
	}

	public void execute() {
		log.debug("executing " + this.getClass().getCanonicalName());

		// TODO: Implementación

		this.setViewPath("/WEB-INF/jsp/es/canamito/app/view/process/Login.jsp");
		try {
			log.debug("viewing with " + getViewPath());
			getRequest().getRequestDispatcher(getViewPath()).forward(getRequest(), getResponse());
		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
		}
	}

}
