package es.canamito.app.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.persistance.controller.CBDalUtils;
import es.canamito.persistance.model.CMenu;
import es.canamito.persistance.model.CUser;

/**
 * Filtro principal que evalua si el usuario tiene acceso al recurso solicitado
 * 
 * @author wkl
 * @version 1.210522 - Documentación e implementación inicial del filtro
 * @version 1.210603 - Implementación del método grantAccess
 */
@WebFilter("/*")
public class CBFlowFilter implements Filter {

	private static final Logger log = LogManager.getLogger();

	public void init(FilterConfig fConfig) throws ServletException {
		// Se invoca una sola vez al levantar Tomcat
	}

	public void destroy() {
		// Llamado cada vez que pasa un tiempo y todos los doFilter han terminado
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (path.startsWith("/app/")) {
			log.info("doFilter to " + path);

			if (grantAccess(httpRequest)) {
				request.getRequestDispatcher(path).forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp")
						.forward(request, response);
			}
		} else if (path.startsWith("/resources/")) {
			log.trace("doChain to " + path);
			chain.doFilter(request, response);
		} else if (path.startsWith("/")) {
			log.info("redirecting to " + httpRequest.getContextPath() + "/app/HomePage");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/app/HomePage");
		} else {
			log.info("unauthorized access to " + path);
			request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp").forward(request,
					response);
		}
	}

	/**
	 * Función que determina si se le concede acceso al usuario al recurso que está
	 * solicitando
	 * 
	 * @return true si el usuario tiene acceso al recurso, false si no
	 */
	private boolean grantAccess(HttpServletRequest httpRequest) {
		boolean res = false;

		CUser cUser = CBDalUtils.getUserInSession(httpRequest);
		final String goingTo = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length())
				.replace("/app/", "");

		Set<CMenu> userMenus = CBDalUtils.getUserMenus(cUser);

		res = userMenus.stream().filter(m -> m.getPath() != null).anyMatch(m -> m.getPath().equals(goingTo)) ? true
				: false;

		if (cUser != null) {
			if (res) {
				log.trace("access granted for " + cUser.getEmail() + " to " + goingTo);
			} else {
				log.info("access rejected for " + cUser.getEmail() + " to " + goingTo);
			}
		} else {
			if (res) {
				log.trace("access granted for anonymous to " + goingTo);
			} else {
				log.trace("access rejected for anonymous to " + goingTo);
			}
		}
		return res;
	}
}