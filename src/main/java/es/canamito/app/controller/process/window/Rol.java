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

public class Rol extends CBWindowImpl implements CBProcess {

	public Rol() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

		getRequest().setAttribute("title", "Roles");

		if (isPost()) {
			log.info("setRequest: posting rol");

			String id = (String) getRequest().getParameter("inpid");

			String name = (String) getRequest().getParameter("inpname");
			String description = (String) getRequest().getParameter("inpdescription");

			setRol(id, name, description);
		}

		CBDal cbd = new CBDal();
		TypedQuery<CRol> query = cbd.getEntityManager().createNamedQuery("CRol.findAll", CRol.class);
		List<CRol> lRoles = query.getResultList();

		List<CBWindowable> model = new ArrayList<CBWindowable>();
		for (CRol cp : lRoles) {
			model.add(cp);
		}

		CTable metadata = getMetadata("c_rol");

		Map<CTable, List<CBWindowable>> table = new HashMap<CTable, List<CBWindowable>>();
		table.put(metadata, model);

		setTable(table);
	}

	/**
	 * Actualiza el rol del usuario
	 * 
	 * @param id          Identificador único del rol
	 * @param name        Nombre del rol
	 * @param description Descripción del rol
	 * @return El rol actualizado
	 */
	private CRol setRol(String id, String name, String description) {
		CRol res = null;

		try {
			CBDal cbd = new CBDal();

			cbd.getEntityTransaction().begin();
			if (id != null) {
				int cRolId = Integer.valueOf(id);
				String sql = "SELECT p FROM CRol p WHERE " + "p.cRolId=" + cRolId;

				Query q = cbd.getEntityManager().createQuery(sql);
				res = (CRol) q.getSingleResult();
			} else {
				res = new CRol();
				cbd.getEntityManager().persist(res);
			}
			res.setName(name);
			res.setDescription(description);

			cbd.getEntityTransaction().commit();

			CBMessage msg = new CBMessage("success", "Edición con exito", "Id: " + id + ", name: " + name);
			getRequest().getSession().setAttribute("msg", msg);

		} catch (Exception e) {
			log.error("setRol: " + e.getClass() + ": " + e.getMessage());
			CBMessage msg = new CBMessage("danger", "Error al editar", "Id: " + id + ", name: " + name, e);
			getRequest().getSession().setAttribute("msg", msg);
		}
		return res;
	}
}
