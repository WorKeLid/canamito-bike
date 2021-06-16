package es.canamito.app.controller.process;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.canamito.app.model.CBMessage;
import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBProcessImpl;
import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CUser;

/**
 * Proceso para ofrecer un ingreso de sesión
 * 
 * @author wkl
 * @version 1.210603 - Implementación y documentación inicial
 */
public class Login extends CBProcessImpl implements CBProcess {

	public Login() {
		super();
	}

	public void execute() throws Exception {
		log.debug("executing " + this.getClass().getCanonicalName());

		if (isPost()) {
			log.trace("incoming post");

			CUser user = isUser();

			if (user != null) {
				getRequest().getSession().setAttribute("user", user);
				try {
					CBMessage msg = new CBMessage("success", "Bienvenido", "");
					getRequest().getSession().setAttribute("msg", msg);
					getResponse().sendRedirect((getRequest().getContextPath() + "/"));
				} catch (IOException e) {
					log.error(e.getClass() + ": " + e.getMessage());
				}
				return;
			} else {
				log.info("invalid credentials");

				CBMessage msg = new CBMessage("warning", "Credenciales no válidas",
						"El correo electrónico no existe o la contraseña es incorrecta");
				getRequest().getSession().setAttribute("msg", msg);
			}
		}
		log.debug("viewing with " + getProcessDefaultView());
		getRequest().getRequestDispatcher(getProcessDefaultView()).forward(getRequest(), getResponse());
	}

	/**
	 * Comprueba si las credenciales recibidas a través de la petición POST
	 * coinciden con las de algún usuario registrado
	 * 
	 * @return El usuario si existe, null si no
	 */
	private CUser isUser() {
		CUser res = null;
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CUser> cQuery = cBuilder.createQuery(CUser.class);
			Root<CUser> root = cQuery.from(CUser.class);

			cQuery.select(root).where(cBuilder.equal(root.get("email"), getRequest().getParameter("input_email")));

			TypedQuery<CUser> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CUser> lUser = tQuery.getResultList();

			if (!lUser.isEmpty()) {
				if (lUser.get(0).getPassword().equals(getRequest().getParameter("input_password"))) {
					res = lUser.get(0);
					log.trace("login succesful as " + res.getEmail());
				} else {
					log.trace("invalid password");
				}
			} else {
				log.info("email does not exist");
			}
		} catch (Exception e) {
			log.error("isUser: " + e.getClass() + ": " + e.getMessage());
		}
		return res;
	}
}
