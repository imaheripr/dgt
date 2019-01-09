package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.pojos.Coche;

@WebServlet("/privado/buscar")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(BuscarController.class);
	private static final String BUSCAR_JSP = "buscarMatricula.jsp";
	private static final String MATRICULA_JSP = "matricula.jsp";
	
	private CocheDAO CocheDAO = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		CocheDAO = CocheDAO.getInstance();
    	
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("mensaje", "Busca para multar");
		request.getRequestDispatcher(BUSCAR_JSP).forward(request, response);
		LOG.debug("Entrando buscador matricula");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 60 * 24 * 365 * 10);
		
		String matriculaBuscar = request.getParameter("buscar");
		Coche c = new Coche();
		c = CocheDAO.getMatricula(matriculaBuscar);
		
		if(c!=null) {
		session.setAttribute("coche", c);
		request.getRequestDispatcher(MATRICULA_JSP).forward(request, response);
		}else {
			session.setAttribute("mensaje", "La matricula no existe");
			request.getRequestDispatcher(BUSCAR_JSP).forward(request, response);
		}
		
		
	}
	
		

}