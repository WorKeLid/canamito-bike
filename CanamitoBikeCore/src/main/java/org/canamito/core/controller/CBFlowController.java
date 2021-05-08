package org.canamito.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class CanamitoController
 */
@WebServlet("/CBFlowController")
public class CBFlowController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CBFlowController() {
		super();
		// TODO:
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * TODO: Buscar el proceso en la base de datos y redireccionar al servlet
		 * apropiado
		 */
		log.debug("doGet to SchoolTestServlet");
		response.sendRedirect("SchoolTestServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO:
		doGet(request, response);
	}

}
