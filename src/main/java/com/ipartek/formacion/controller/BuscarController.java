package com.ipartek.formacion.controller;

import java.io.IOException; //

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.pojos.Coche;

@WebServlet("/privado/buscar")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// LOG
	private final static Logger LOG = Logger.getLogger(BuscarController.class);

	// VISTAS
	private static final String BUSCAR_JSP = "buscarMatricula.jsp";
	private static final String MATRICULA_JSP = "multa.jsp";

	private CocheDAO cocheDAO = null;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		cocheDAO = CocheDAO.getInstance();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("mensaje", "Busca una matricula ");

		request.getRequestDispatcher(BUSCAR_JSP).forward(request, response);
		LOG.debug("Entrando buscador matricula");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matriculaBuscar = request.getParameter("buscar");
		Coche c = new Coche();
		c = cocheDAO.getMatricula(matriculaBuscar);

		if (c != null) {
			request.setAttribute("coche", c);
			request.setAttribute("mensaje", "Todos los campos son obligatorios");
			request.getRequestDispatcher(MATRICULA_JSP).forward(request, response);
		} else {
			request.setAttribute("matricula", matriculaBuscar);
			request.setAttribute("mensaje", "La matricula no existe");
			
			request.getRequestDispatcher(BUSCAR_JSP).forward(request, response);
		}

	}

}