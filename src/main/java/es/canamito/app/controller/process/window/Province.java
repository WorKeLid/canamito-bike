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
import es.canamito.persistance.model.CProvince;
import es.canamito.persistance.model.CTable;

/**
 * Proceso ventana para mostrar información sobre las provincias
 * 
 * @author wkl
 * @version 1.210611 - Implementación y documentación inicial
 */
public class Province extends CBWindowImpl implements CBProcess {

	public Province() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

		getRequest().setAttribute("title", "Provincias");

		if (isPost()) {
			log.info("setRequest: posting province");

			String id = (String) getRequest().getParameter("inpid");
			String name = (String) getRequest().getParameter("inpname");

			setProvince(id, name);
		}

		CBDal cbd = new CBDal();
		TypedQuery<CProvince> query = cbd.getEntityManager().createNamedQuery("CProvince.findAll", CProvince.class);
		List<CProvince> lProvinces = query.getResultList();

		List<CBWindowable> model = new ArrayList<CBWindowable>();
		for (CProvince cp : lProvinces) {
			model.add(cp);
		}

		CTable metadata = getMetadata("c_province");

		Map<CTable, List<CBWindowable>> table = new HashMap<CTable, List<CBWindowable>>();
		table.put(metadata, model);

		setTable(table);
	}

	/**
	 * Actualiza la provincia
	 * 
	 * @param id   Identificador de la provincia
	 * @param name El nuevo nombre de la provincia
	 * @return La provincia editada
	 */
	private CProvince setProvince(String id, String name) {
		CProvince res = null;

		try {
			CBDal cbd = new CBDal();

			cbd.getEntityTransaction().begin();
			if (id != null) {
				int cProvinceId = Integer.valueOf(id);
				String sql = "SELECT p FROM CProvince p WHERE " + "p.cProvinceId=" + cProvinceId;

				Query q = cbd.getEntityManager().createQuery(sql);
				res = (CProvince) q.getSingleResult();
			} else {
				res = new CProvince();
				cbd.getEntityManager().persist(res);
			}
			res.setName(name);

			cbd.getEntityTransaction().commit();

			CBMessage msg = new CBMessage("success", "Edición con exito", "Id: " + id + ", nombre: " + name);
			getRequest().getSession().setAttribute("msg", msg);

		} catch (Exception e) {
			log.error("setProvince: " + e.getClass() + ": " + e.getMessage());
			CBMessage msg = new CBMessage("danger", "Error al editar", "Id: " + id + ", nombre: " + name, e);
			getRequest().getSession().setAttribute("msg", msg);
		}
		return res;
	}
}
