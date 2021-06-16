package es.canamito.app.model.process;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CBModel;
import es.canamito.persistance.model.CTable;

/**
 * Implementacion padre de procesos de tipo ventana
 * 
 * @author wkl
 * @version 1.210609 - Implementación inicial
 */
public class CBWindowImpl extends CBProcessImpl implements CBProcess {

	private Map<CTable, List<CBModel>> table;

	public CBWindowImpl() {
		super();
	}

	protected void setTable(Map<CTable, List<CBModel>> table) {
		this.table = table;
	}

	protected Map<CTable, List<CBModel>> getTable() {
		return this.table;
	}

	public void execute() throws Exception {

		getRequest().setAttribute("table", getTable());
		getRequest().setAttribute("process", getCProcess());

		log.debug("viewing with " + getProcessDefaultView());
		getRequest().getRequestDispatcher(getProcessDefaultView()).forward(getRequest(), getResponse());
	}

	/**
	 * Devuelve información sobre la tabla
	 * 
	 * @param table Nombre de la tabla en la base de datos
	 * @return CTable con información sobre la tabla
	 */
	protected CTable getMetadata(String table) {
		CTable res = null;
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CTable> cQuery = cBuilder.createQuery(CTable.class);

			TypedQuery<CTable> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CTable> lTables = tQuery.getResultList();

			res = lTables.stream().filter(t -> t.getDbName().equals(table)).collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			log.error("getMetadata: " + e.getClass() + ": " + e.getMessage());
		}
		return res;
	}

//	private void getTableData(List<CWindowTable> lWindowTables) throws Exception {
//
//		CBDal cbd = new CBDal();
//
//		for (CWindowTable cwt : lWindowTables) {
//			String q = "SELECT ";
//			List<CColumn> columns = cwt.getCTable().getCColumns();
//			for (int i = 0; i < columns.size(); i++) {
//				if (i >= columns.size() - 1) {
//					q += "e." + columns.get(i).getAttributeName() + " ";
//				} else {
//					q += "e." + columns.get(i).getAttributeName() + ", ";
//				}
//			}
//			q += "FROM " + cwt.getCTable().getClassName() + " e";
//
//			log.info("executing query: " + q);
//			// Query query = cbd.getEntityManager().createQuery(q);
//
//			Class<?> c = Class.forName("es.canamito.persistance.model." + cwt.getCTable().getClassName());
//
//			log.debug(c.getName());
//
//			TypedQuery<?> query = cbd.getEntityManager().createQuery(q, c);
//
//			List<?> res = query.getResultList();
//
//			for (Object r : res) {
//				if (r instanceof CProvince) {
//					CProvince cp = (CProvince) r;
//					log.debug("province: " + cp.getName());
//				} else if (r instanceof CLocality) {
//					CLocality cl = (CLocality) r;
//					log.debug("locality: " + cl.getName());
//				}
//
//			}
//
//		}

}
