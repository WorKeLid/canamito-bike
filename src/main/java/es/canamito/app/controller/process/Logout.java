package es.canamito.app.controller.process;

import es.canamito.app.model.CBMessage;
import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBProcessImpl;
import es.canamito.persistance.controller.CBDalUtils;
import es.canamito.persistance.model.CUser;

/**
 * Proceso para invalidar la sesión
 * 
 * @author wkl
 * @version 1.210617 - Implementación y documentación inicial
 */
public class Logout extends CBProcessImpl implements CBProcess {

	public Logout() {
		super();
	}

	public void execute() throws Exception {
		log.trace("execute: " + this.getClass().getCanonicalName());

		CUser cUser = CBDalUtils.getUserInSession(getRequest());

		if (cUser != null) {
			log.trace("execute: " + cUser.getEmail() + " login out");
			getRequest().getSession().invalidate();

			CBMessage msg = new CBMessage("success", "Hasta la próxima", "");
			getRequest().getSession().setAttribute("msg", msg);
		} else {
			log.error("execute: there is no user in session to begin with");
		}
		getResponse().sendRedirect((getRequest().getContextPath() + "/"));
	}

}
