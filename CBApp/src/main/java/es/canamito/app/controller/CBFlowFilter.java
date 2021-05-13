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
 * Filtro principal que evalua si el usuario tiene acceso a l proceso solicitado
 */
@WebFilter("/*")
// TODO: Documentación
// TODO: Implementación
public class CBFlowFilter implements Filter {

	private static final Logger log = LogManager.getLogger();

	public CBFlowFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log.debug("init");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("doFilter to " + ((HttpServletRequest) request).getRequestURL().toString());
		chain.doFilter(request, response);
	}

	public void destroy() {
		log.debug("destroy");
	}
}
