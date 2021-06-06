package es.canamito.app.model.process;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CProcess;
import es.canamito.persistance.model.CProcessView;

/**
 * <div>Clase abstracta que deja la implementación de su ejecucion a sus
 * hijos</div>
 * 
 * @author wkl
 * @version 1.210515 - Documentacion e implementación de la clase abstracta
 */
public abstract class CBProcessImpl implements CBProcess {

	protected static final Logger log = LogManager.getLogger();

	private ServletContext servletContext;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	private String viewPath;

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public HttpServletRequest getRequest() {
		return this.httpServletRequest;
	}

	public HttpServletResponse getResponse() {
		return this.httpServletResponse;
	}

	public String getViewPath() {
		return this.viewPath;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	/**
	 * @return true si el proceso ha recibido una petición POST, false si no
	 */
	public boolean isPost() {
		return "POST".equalsIgnoreCase(getRequest().getMethod()) == true ? true : false;
	}

	/**
	 * Busca la vista por defecto del proceso dado
	 * 
	 * @param fullClassName Nombre completo de la clase que implementa al proceso
	 * @return La ruta de la vista o la vista Unauthorized si no la encuentra
	 */
	public String getDefaultView(String fullProcessName) {
		String res = "/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp";
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CProcess> cQuery = cBuilder.createQuery(CProcess.class);
			Root<CProcess> root = cQuery.from(CProcess.class);

			cQuery.select(root).where(cBuilder.equal(root.get("processPath"), fullProcessName));

			TypedQuery<CProcess> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CProcess> lProcess = tQuery.getResultList();

			if (!lProcess.isEmpty()) {
				CProcess process = lProcess.get(0);

				if (!process.getCProcessViews().isEmpty()) {
					List<CProcessView> lProcessView = process.getCProcessViews().stream()
							.filter(pv -> pv.getIsDefault()).collect(Collectors.toList());

					CProcessView processView;
					if (!lProcessView.isEmpty() && lProcessView.size() == 1) {
						processView = lProcessView.get(0);
					} else {
						log.error("process does not have a default view o has multiple default views");
						processView = process.getCProcessViews().get(0);
					}
					res = processView.getCView().getJspPath();
				} else {
					log.error("process does not have defined views");
				}
			} else {
				log.fatal("process does not exist");
			}
		} catch (Exception e) {
			log.error("getDefaultView: " + e.getClass() + ": " + e.getMessage());
		}
		log.info("default view for " + fullProcessName + ": " + res);
		return res;
	}

	/**
	 * <div>Este método debe evaluar la petición y respuestas recibidas y generar
	 * una respuesta</div>
	 */
	public abstract void execute();
}
