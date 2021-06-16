package es.canamito.app.controller.process;

import es.canamito.app.model.CBMessage;
import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBProcessImpl;
import es.canamito.persistance.controller.CBDalUtils;
import es.canamito.persistance.model.CUser;

public class Logout extends CBProcessImpl implements CBProcess {

	public Logout() {
		super();
	}

	public void execute() throws Exception {
		log.debug("executing " + this.getClass().getCanonicalName());

		CUser cUser = CBDalUtils.getUserInSession(getRequest());

		if (cUser != null) {
			log.trace(cUser.getEmail() + " login out");
			getRequest().getSession().invalidate();

			CBMessage msg = new CBMessage("success", "Hasta la próxima", null);
			getRequest().getSession().setAttribute("msg", msg);
		} else {
			log.error("there is no user in session to begin with");
		}

		getResponse().sendRedirect((getRequest().getContextPath() + "/"));
	}

}
