package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import com.ipartek.formacion.pojos.Multa;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/privado/listar")
public class ListarController extends HttpServlet {
	private static final int ID_AGENTE_PREDEFINIDO = 4;
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	
	private AgenteDAO AgenteDAO = null;
	String view = "listadoMultas.jsp";
	
	
	
	ArrayList<Multa> multas = null;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		AgenteDAO = AgenteDAO.getInstance();
		multas  = new ArrayList<Multa>();
	}
       
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 60 * 24 * 365 * 10);
		multas = AgenteDAO.getMultas(ID_AGENTE_PREDEFINIDO);
		session.setAttribute("multas", multas);
		request.getRequestDispatcher(view).forward(request, response);
		
		
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	
	

}
