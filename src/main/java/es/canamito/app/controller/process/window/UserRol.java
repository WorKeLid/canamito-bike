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
import es.canamito.persistance.model.CRol;
import es.canamito.persistance.model.CTable;
import es.canamito.persistance.model.CUser;
import es.canamito.persistance.model.CUserRol;

public class UserRol extends CBWindowImpl implements CBProcess {

	public UserRol() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

		getRequest().setAttribute("title", "Roles de usuarios");

		if (isPost()) {
			log.info("setRequest: posting user rol");

			String id = (String) getRequest().getParameter("inpid");

			String cUserId = (String) getRequest().getParameter("inpCUser");
			String cRolId = (String) getRequest().getParameter("inpCRol");

			setUserRol(id, cUserId, cRolId);
		}

		CBDal cbd = new CBDal();
		TypedQuery<CUserRol> query = cbd.getEntityManager().createNamedQuery("CUserRol.findAll", CUserRol.class);
		List<CUserRol> lUserRoles = query.getResultList();

		List<CBWindowable> model = new ArrayList<CBWindowable>();
		for (CUserRol cp : lUserRoles) {
			model.add(cp);
		}

		CTable metadata = getMetadata("c_rol_user");

		Map<CTable, List<CBWindowable>> table = new HashMap<CTable, List<CBWindowable>>();
		table.put(metadata, model);

		setTable(table);
	}

	private CUserRol setUserRol(String id, String cUserId, String cRolId) {
		CUserRol res = null;

		try {
			CBDal cbd = new CBDal();

			cbd.getEntityTransaction().begin();
			if (id != null) {
				int cUserRolId = Integer.valueOf(id);
				String sql = "SELECT p FROM CUserRol p WHERE " + "p.cUserRolId=" + cUserRolId;

				Query q = cbd.getEntityManager().createQuery(sql);
				res = (CUserRol) q.getSingleResult();
			} else {
				res = new CUserRol();
				cbd.getEntityManager().persist(res);
			}

			if (!cUserId.equals("")) {
				CUser cUser = cbd.getEntityManager().find(CUser.class, Integer.valueOf(cUserId));
				res.setCUser(cUser);
			} else {
				res.setCUser(null);
			}
			if (!cRolId.equals("")) {
				CRol cRol = cbd.getEntityManager().find(CRol.class, Integer.valueOf(cRolId));
				res.setCRol(cRol);
			} else {
				res.setCUser(null);
			}

			cbd.getEntityTransaction().commit();

			CBMessage msg = new CBMessage("success", "Edición con exito", "Id: " + id);
			getRequest().getSession().setAttribute("msg", msg);

		} catch (Exception e) {
			log.error("setRol: " + e.getClass() + ": " + e.getMessage());
			CBMessage msg = new CBMessage("danger", "Error al editar",
					"Id: " + id + ", user: " + cUserId + ", rol: " + cRolId, e);
			getRequest().getSession().setAttribute("msg", msg);
		}
		return res;
	}
}
