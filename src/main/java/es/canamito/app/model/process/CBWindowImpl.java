package es.canamito.app.model.process;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CBWindowable;
import es.canamito.persistance.model.CTable;

/**
 * Implementacion padre de procesos de tipo ventana. Recibe de sus hijos un mapa
 * con la tabla a mostrar y el proceso hijo que ha sido ejecutado
 * 
 * @author wkl
 * @version 1.210609 - Implementación inicial
 */
public class CBWindowImpl extends CBProcessImpl implements CBProcess {

	private Map<CTable, List<CBWindowable>> table;

	public CBWindowImpl() {
		super();
	}

	protected void setTable(Map<CTable, List<CBWindowable>> table) {
		this.table = table;
	}

	protected Map<CTable, List<CBWindowable>> getTable() {
		return this.table;
	}

	/**
	 * Obtiene del proceso ventana hijo la un mapa con la tabla a mostrar y una
	 * referencia al proceso que se ha ejecutado
	 */
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
}