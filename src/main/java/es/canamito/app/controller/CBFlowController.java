package es.canamito.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.app.model.process.CBProcess;
import es.canamito.persistance.controller.CBDalUtils;
import es.canamito.persistance.model.CProcess;

/**
 * Controlador principal que ejecuta el proceso solicitado
 * 
 * @author wkl
 * @version 1.210522 - Documentación e implementación inicial del controlador
 *          principal
 * @version 1.210603 - Implementación del método getProcessFromMenu
 */
@WebServlet("/app/*")
public class CBFlowController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doGet to " + request.getRequestURI().substring(request.getContextPath().length()));
		try {

			CProcess process = CBDalUtils.getProcessFromMenu(request);

			if (process != null) {
				Class<?> c = Class.forName(process.getProcessPath());

				CBProcess p = (CBProcess) c.getDeclaredConstructor().newInstance();

				p.setServletContext(this.getServletContext());
				p.setRequest(request);
				p.setResponse(response);
				p.setCProcess(process);

				p.execute();
			} else {
				String goingTo = request.getRequestURI().substring(request.getContextPath().length()).replace("/app/",
						"");
				log.info("process " + goingTo + " does not exist");
				request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp")
						.forward(request, response);
			}
		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getCause().getClass() + ": " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp").forward(request,
					response);
		} finally {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("doPost to " + request.getRequestURI().substring(request.getContextPath().length()));
		doGet(request, response);
	}

}
