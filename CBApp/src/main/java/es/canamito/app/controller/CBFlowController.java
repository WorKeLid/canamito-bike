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
 */
@WebServlet("/")
// TODO: Documentación
// TODO: Implementación
public class CBFlowController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger();

	public CBFlowController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("doGet to " + request.getServletPath());

		try {

			String goingTo = request.getServletPath();
			goingTo = goingTo.replace("/", "");

			Class<?> c = Class.forName("es.canamito.app.model.process." + goingTo);

			CBProcess p = (CBProcess) c.getDeclaredConstructor().newInstance();

			p.setRequest(request);
			p.setResponse(response);

			p.execute();

		} catch (Exception e) {
			log.error(e.getClass() + ": " + e.getMessage());
		} finally {

		}

		// request.getRequestDispatcher("/index.jsp").forward(request, response);
		// response.sendRedirect("Utils");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
