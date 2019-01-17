package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.AgenteDAO;


@WebServlet("/privado/principal")
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
	private final static Logger LOG = Logger.getLogger(PrincipalController.class);
	//VISTAS
	private static final String PRINCIPAL_JSP = "principal.jsp";
	
	private static AgenteDAO agenteDAO = null;
  
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	agenteDAO = agenteDAO.getInstance();
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher(PRINCIPAL_JSP).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	



}
