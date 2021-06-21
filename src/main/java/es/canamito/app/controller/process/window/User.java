package es.canamito.app.controller.process.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import es.canamito.app.model.CBMessage;
import es.canamito.app.model.process.CBProcess;
import es.canamito.app.model.process.CBWindowImpl;
import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CBWindowable;
import es.canamito.persistance.model.CPerson;
import es.canamito.persistance.model.CTable;
import es.canamito.persistance.model.CUser;

public class User extends CBWindowImpl implements CBProcess {

	public User() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

		getRequest().setAttribute("title", "Usuarios");

		if (isPost()) {
			log.info("setRequest: posting user");

			String id = (String) getRequest().getParameter("inpid");

			String email = (String) getRequest().getParameter("inpemail");
			String password = (String) getRequest().getParameter("inppassword");
			String isProtected = (String) getRequest().getParameter("inpisProtected");
			String isActive = (String) getRequest().getParameter("inpisActive");
			String CPerson = (String) getRequest().getParameter("inpCPerson");

			setUser(id, email, password, isProtected, isActive, CPerson);
		}

		CBDal cbd = new CBDal();
		TypedQuery<CUser> query = cbd.getEntityManager().createNamedQuery("CUser.findAll", CUser.class);
		List<CUser> lUsers = query.getResultList();

		List<CBWindowable> model = new ArrayList<CBWindowable>();
		for (CUser cp : lUsers) {
			model.add(cp);
		}

		CTable metadata = getMetadata("c_user");

		Map<CTable, List<CBWindowable>> table = new HashMap<CTable, List<CBWindowable>>();
		table.put(metadata, model);

		setTable(table);
	}

	/**
	 * Actualiza el usuario
	 * 
	 * @param id          Identificador del usuario
	 * @param email       Correo electrónico del usuario
	 * @param password    Contraseña del usuario
	 * @param isProtected Si el usuario está bloqueado
	 * @param isActive    Si el usuario está activo
	 * @param cPersonId   Identificador de la persona relacionada con el usuario
	 * @return El usuario editado
	 */
	private CUser setUser(String id, String email, String password, String isProtected, String isActive,
			String cPersonId) {
		CUser res = null;

		try {
			CBDal cbd = new CBDal();

			cbd.getEntityTransaction().begin();
			if (id != null) {
				int cUserId = Integer.valueOf(id);
				String sql = "SELECT p FROM CUser p WHERE " + "p.cUserId=" + cUserId;

				Query q = cbd.getEntityManager().createQuery(sql);
				res = (CUser) q.getSingleResult();
			} else {
				res = new CUser();
				cbd.getEntityManager().persist(res);
			}
			res.setEmail(email);
			res.setPassword(password);
			res.setIsProtected(isProtected == null ? false : true);
			res.setIsActive(isActive == null ? false : true);

			if (!cPersonId.equals("")) {
				CPerson cPerson = cbd.getEntityManager().find(CPerson.class, Integer.valueOf(cPersonId));
				res.setCPerson(cPerson);
			} else {
				res.setCPerson(null);
			}

			cbd.getEntityTransaction().commit();

			CBMessage msg = new CBMessage("success", "Edición con exito", "Id: " + id + ", email: " + email);
			getRequest().getSession().setAttribute("msg", msg);

		} catch (Exception e) {
			log.error("setUser: " + e.getClass() + ": " + e.getMessage());
			CBMessage msg = new CBMessage("danger", "Error al editar", "Id: " + id + ", email: " + email, e);
			getRequest().getSession().setAttribute("msg", msg);
		}
		return res;
	}

}
