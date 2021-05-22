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

			Class<?> c = Class.forName("es.canamito.app.model.process." + goingTo);

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
		doGet(request, response);
	}
}
