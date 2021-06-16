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
import es.canamito.persistance.model.CRol;
import es.canamito.persistance.model.CUser;
import es.canamito.persistance.model.CUserRol;

public class Signin extends CBProcessImpl implements CBProcess {

	@Override
	public void execute() throws Exception {
		log.debug("executing " + this.getClass().getCanonicalName());

		if (isPost()) {
			log.trace("incoming post");

			if (!isEmailRegistered()) {
				CUser user = registerUser();
				if (user != null) {
					getRequest().getSession().setAttribute("user", user);
					try {
						CBMessage msg = new CBMessage("success", "Bienvenido",
								"Te damos la bienvenida a Cañamito Bike");
						getRequest().getSession().setAttribute("msg", msg);
						getResponse().sendRedirect((getRequest().getContextPath() + "/"));
					} catch (IOException e) {
						log.error(e.getClass() + ": " + e.getMessage());
					}
					return;
				}
			} else {
				log.info("email already in use");

				CBMessage msg = new CBMessage("warning", "Correo electrónico en uso",
						"El correo electrónico ya se encuentra registrado");
				getRequest().setAttribute("msg", msg);

				getRequest().getRequestDispatcher(getProcessDefaultView()).forward(getRequest(), getResponse());
			}

		} else {

			log.trace("viewing with " + getProcessDefaultView());
			getRequest().getRequestDispatcher(getProcessDefaultView()).forward(getRequest(), getResponse());
		}

	}

	private boolean isEmailRegistered() {
		boolean res = false;
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CUser> cQuery = cBuilder.createQuery(CUser.class);
			Root<CUser> root = cQuery.from(CUser.class);

			cQuery.select(root).where(cBuilder.equal(root.get("email"), getRequest().getParameter("input_email")));

			TypedQuery<CUser> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CUser> lUser = tQuery.getResultList();

			if (!lUser.isEmpty()) {
				res = true;
			}
		} catch (Exception e) {
			log.error("isEmailRegistered: " + e.getClass() + ": " + e.getMessage());
		}
		return res;
	}

	private CUser registerUser() {
		CUser res = new CUser();
		res.setEmail(getRequest().getParameter("input_email"));
		res.setPassword(getRequest().getParameter("input_password"));
		res.setIsActive(true);
		res.setIsProtected(false);

		CUserRol cur = new CUserRol();
		cur.setCUser(res);
		cur.setCRol(getUserRole());

		res.addCUserRol(cur);

		CBDal cbd = new CBDal();

		cbd.getEntityManager().getTransaction().begin();

		cbd.getEntityManager().persist(res);
		cbd.getEntityManager().persist(cur);

		cbd.getEntityManager().getTransaction().commit();

		return res;
	}

	private CRol getUserRole() {

		CBDal cbd = new CBDal();

		CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<CRol> cQuery = cBuilder.createQuery(CRol.class);
		Root<CRol> root = cQuery.from(CRol.class);

		cQuery.select(root).where(cBuilder.equal(root.get("name"), "Usuario"));

		TypedQuery<CRol> tQuery = cbd.getEntityManager().createQuery(cQuery);

		return tQuery.getSingleResult();
	}

	/*
	 * TODO: You have two options:
	 * 
	 * persist also other instances referenced from Article via em.persist
	 * 
	 * cascade persist operation from Article to HeaderFields with following
	 * 
	 * OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST) private
	 * List<HeaderField> someOrAllHeaderFields = new ArrayList<>();
	 * 
	 */
}
