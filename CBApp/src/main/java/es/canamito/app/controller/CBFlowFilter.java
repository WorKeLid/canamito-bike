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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Filtro principal que evalua si el usuario tiene acceso al proceso solicitado
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

			if (grantAccess()) {
				request.getRequestDispatcher(path).forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/jsp/es/canamito/app/view/process/Unauthorized.jsp")
						.forward(request, response);
			}

		} else {
			log.trace("doChain to " + path);
			chain.doFilter(request, response);
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
	private boolean grantAccess() {
		/*
		 * 1. Obtener el usuario que hay en la session o anonimo si no hay 2. Evaluar si
		 * ese usuario tiene acceso al recurso que está solicitando 3. Permitir el
		 * acceso (chain.doFilter ...) o redirigir a página de acceso no autorizado
		 */
		// TODO: Implementación
		return true;
	}
}
