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
import es.canamito.persistance.model.CBModel;
import es.canamito.persistance.model.CProvince;
import es.canamito.persistance.model.CTable;

/**
 * Proceso ventana para mostrar información sobre las provincias
 * 
 * @author wkl
 * @version 1.210611 - Implementación inicial
 */
public class Province extends CBWindowImpl implements CBProcess {

	public Province() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

		getRequest().setAttribute("title", "Provincias");

		if (isPost()) {
			log.debug("posting province");

			String id = (String) getRequest().getParameter("inpid");
			String name = (String) getRequest().getParameter("inpname");

			setProvince(id, name);

			CBDal cbd = new CBDal();
			TypedQuery<CProvince> query = cbd.getEntityManager().createNamedQuery("CProvince.findAll", CProvince.class);
			List<CProvince> lProvinces = query.getResultList();

			List<CBModel> model = new ArrayList<CBModel>();
			for (CProvince cp : lProvinces) {
				model.add(cp);
			}

			CTable metadata = getMetadata("c_province");

			Map<CTable, List<CBModel>> table = new HashMap<CTable, List<CBModel>>();
			table.put(metadata, model);

			CBMessage msg = new CBMessage("success", "Edición con exito", "Id: " + id + ", nombre: " + name);
			getRequest().getSession().setAttribute("msg", msg);

			setTable(table);

		} else {
			CBDal cbd = new CBDal();
			TypedQuery<CProvince> query = cbd.getEntityManager().createNamedQuery("CProvince.findAll", CProvince.class);
			List<CProvince> lProvinces = query.getResultList();

			List<CBModel> model = new ArrayList<CBModel>();
			for (CProvince cp : lProvinces) {
				model.add(cp);
			}

			CTable metadata = getMetadata("c_province");

			Map<CTable, List<CBModel>> table = new HashMap<CTable, List<CBModel>>();
			table.put(metadata, model);

			setTable(table);
		}
	}

	private CProvince setProvince(String id, String name) {
		CProvince res = null;
		int cProvinceId = Integer.valueOf(id);

		String sql = "SELECT p FROM CProvince p WHERE " + "p.cProvinceId=" + cProvinceId;

		try {
			CBDal cbd = new CBDal();

			Query q = cbd.getEntityManager().createQuery(sql);
			res = (CProvince) q.getSingleResult();

			cbd.getEntityTransaction().begin();
			res.setName(name);
			cbd.getEntityTransaction().commit();

		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
		}
		return res;
	}
}
