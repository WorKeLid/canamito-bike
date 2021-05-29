package es.canamito.app.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.canamito.persistance.model.CUser;

/**
 * Filtro principal que evalua si el usuario tiene acceso al recurso solicitado
 * 
 * @author wkl
 * @version 1.210522 - Documentación e implementación inicial del filtro
 */
@WebFilter("/*")
public class CBFlowFilter implements Filter {

	private static final Logger log = LogManager.getLogger();

	public void init(FilterConfig fConfig) throws ServletException {
		// Se invoca una sola vez al levantar Tomcat
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (path.startsWith("/app/")) {
			log.debug("doFilter to " + path);
			if (grantAccess(httpRequest)) {
				request.getRequestDispatcher(path).forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp")
						.forward(request, response);
			}
		} else if (path.startsWith("/resources/")) {
			log.trace("doChain to " + path);
			chain.doFilter(request, response);
		} else {
			log.debug("unauthorized access to " + path);
			request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp").forward(request,
					response);
		}
	}

	public void destroy() {
		// Llamado cada vez que pasa un tiempo y todos los doFilter han terminado
	}

	/**
	 * Función que determina si se le concede acceso al usuario al recurso que está
	 * solicitando
	 * 
	 * @return true si el usuario tiene acceso al recurso, false si no
	 */
	private boolean grantAccess(HttpServletRequest httpRequest) {

		HttpSession httpSession = httpRequest.getSession();

		Object userObject = httpSession.getAttribute("CUser");

		if (userObject instanceof CUser) {
			CUser cUser = (CUser) userObject;

			log.debug("session email: " + cUser.getEmail());

		} else {

			log.debug("session anonymous");
		}

		/*
		 * 2. Evaluar si ese usuario tiene acceso al recurso que está solicitando 3.
		 * Permitir el acceso (chain.doFilter ...) o redirigir a página de acceso no
		 * autorizado
		 */
		// TODO: Implementación
		return true;
	}
}
