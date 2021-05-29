package es.canamito.app.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.app.model.process.CBProcess;
import es.canamito.persistance.controller.CBDal;
import es.canamito.persistance.model.CMenu;

/**
 * Controlador principal que ejecuta el proceso solicitado
 * 
 * @author wkl
 * @version 1.210522 - Documentación e implementación inicial del controlador
 *          principal
 */
@WebServlet("/app/*")
public class CBFlowController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("doGet to " + request.getRequestURI().substring(request.getContextPath().length()));
		try {
			String goingTo = request.getRequestURI().substring(request.getContextPath().length());
			goingTo = goingTo.replace("/app/", "");

			String process = getProcessFromMenu(goingTo);

			Class<?> c = Class.forName(process);

			CBProcess p = (CBProcess) c.getDeclaredConstructor().newInstance();

			p.setServletContext(this.getServletContext());
			p.setRequest(request);
			p.setResponse(response);

			p.execute();

		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp").forward(request,
					response);
		} finally {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Implementar lógica sobre información recibida
		log.debug("doPost to " + request.getRequestURI().substring(request.getContextPath().length()));
		doGet(request, response);
	}

	/**
	 * Busca en la base de datos si el proceso solicitado existe
	 * 
	 * @param goingTo Nombre del proceso
	 * @return Nombre del proceso a instanciar o null si no existe
	 */
	private String getProcessFromMenu(String goingTo) {
		String res = null;
		try {
			CBDal cbd = new CBDal();

			CriteriaBuilder cBuilder = cbd.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<CMenu> cQuery = cBuilder.createQuery(CMenu.class);
			Root<CMenu> root = cQuery.from(CMenu.class);

			cQuery.select(root).where(cBuilder.isNotNull(root.get("CProcess")));

			TypedQuery<CMenu> tQuery = cbd.getEntityManager().createQuery(cQuery);

			List<CMenu> lMenus = tQuery.getResultList();

			res = lMenus.stream().filter(m -> m.getPath().equals(goingTo)).findAny().orElse(null).getCProcess()
					.getProcessPath();
		} catch (Exception e) {
			log.error("getProcessFromMenu: " + e.getClass() + ": " + e.getMessage());
			res = "es.canamito.app.controller.process." + goingTo;
		}

		log.info("getProcessFromMenu: calling process " + res);
		return res;
	}
}
