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
import es.canamito.persistance.model.CLocality;
import es.canamito.persistance.model.CProvince;
import es.canamito.persistance.model.CTable;

/**
 * Proceso ventana para mostrar información sobre las localidades
 * 
 * @author wkl
 * @version 1.210619 - Implementación y documentación inicial
 */
public class Locality extends CBWindowImpl implements CBProcess {

	public Locality() {
		super();
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;

		getRequest().setAttribute("title", "Localidades");

		if (isPost()) {
			log.info("setRequest: posting locality");

			String id = (String) getRequest().getParameter("inpid");

			String name = (String) getRequest().getParameter("inpname");
			String postalCode = (String) getRequest().getParameter("inppostalCode");
			String cProvinceId = (String) getRequest().getParameter("inpCProvince");

			setLocality(id, name, postalCode, cProvinceId);
		}

		CBDal cbd = new CBDal();
		TypedQuery<CLocality> query = cbd.getEntityManager().createNamedQuery("CLocality.findAll", CLocality.class);
		List<CLocality> lLocalities = query.getResultList();

		List<CBWindowable> model = new ArrayList<CBWindowable>();
		for (CLocality cp : lLocalities) {
			model.add(cp);
		}

		CTable metadata = getMetadata("c_locality");

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
	private CLocality setLocality(String id, String name, String postalCode, String cProvinceId) {
		CLocality res = null;

		try {
			CBDal cbd = new CBDal();

			cbd.getEntityTransaction().begin();
			if (id != null) {
				int cLocalityId = Integer.valueOf(id);
				String sql = "SELECT p FROM CLocality p WHERE " + "p.cLocalityId=" + cLocalityId;

				Query q = cbd.getEntityManager().createQuery(sql);
				res = (CLocality) q.getSingleResult();
			} else {
				res = new CLocality();
				cbd.getEntityManager().persist(res);
			}
			res.setName(name);
			res.setPostalCode(postalCode);

			if (!cProvinceId.equals("")) {
				CProvince cProvince = cbd.getEntityManager().find(CProvince.class, Integer.valueOf(cProvinceId));
				res.setCProvince(cProvince);
			} else {
				res.setCProvince(null);
			}

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
