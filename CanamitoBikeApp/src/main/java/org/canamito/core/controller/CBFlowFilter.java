package org.canamito.core.controller;

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
 * Servlet Filter implementation class CanamitoMainFilter
 */
@WebFilter("/*")
public class CBFlowFilter implements Filter {

	private static final Logger log = LogManager.getLogger();

	public CBFlowFilter() {
		// TODO:
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		log.debug("init");
		// TODO:
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * TODO: Evaluar si el solicitante tiene acceso a ese proceso en la base de
		 * datos
		 */
		log.debug("doFilter to " + ((HttpServletRequest) request).getRequestURL().toString());
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		log.debug("destroy");
		// TODO:
	}

}
