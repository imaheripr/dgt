package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.AgenteDAO;
import com.ipartek.formacion.daos.MultaDAO;
import com.ipartek.formacion.pojos.Agente;



@WebServlet("/privado/objetivo_agente")
public class ObjetivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
		private final static Logger LOG = Logger.getLogger(ObjetivoController.class);

		private static AgenteDAO agenteDAO = null;
		private static MultaDAO multaDAO = null;
		
		
		@Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	agenteDAO = agenteDAO.getInstance(); 
	    	multaDAO = multaDAO.getInstance();  
	    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id_agente;
			id_agente=request.getParameter("id_agente");
			Agente a = new Agente();
			
			Long id = Long.parseLong(id_agente);
			a.setId(id);

			//multaDAO.objetivos(a.getId());
			request.setAttribute("agente", a);
	
		}catch (Exception e) {
			LOG.error(e);	
			
		}finally {
			request.getRequestDispatcher("privado/objetivos.jsp").forward(request, response);
		}	
	}
	

}
