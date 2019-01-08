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

import com.ipartek.formacion.daos.AgenteDAO;
import com.ipartek.formacion.pojos.Agente;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int ID_AGENTE_PREDEFINIDO = 4;
	private final static Logger LOG = Logger.getLogger(LoginController.class);

	private static final String PRIVADO_PRINCIPAL = "/privado/principal.jsp";
	
	private AgenteDAO AgenteDAO = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		AgenteDAO = AgenteDAO.getInstance();
    	
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);		
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 60 * 24 * 365 * 10);
		Agente a = new Agente();
		a = AgenteDAO.getById(ID_AGENTE_PREDEFINIDO);
		session.setAttribute("agente_logeado", a);
		
		//response.sendRedirect( request.getContextPath() + PRIVADO_PRINCIPAL);
		request.getRequestDispatcher(PRIVADO_PRINCIPAL).forward(request, response);
		
	}
	
}
