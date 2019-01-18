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
import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.daos.MultaDAO;
import com.ipartek.formacion.daos.ObjetivoDAO;
import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Multa;
import com.ipartek.formacion.pojos.Objetivo;



@WebServlet("/privado/objetivos")
public class ObjetivosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
		private final static Logger LOG = Logger.getLogger(ObjetivosController.class);

		private ObjetivoDAO objetivoDAO = null;
		private Objetivo objetivo = null;
		private Objetivo objetivo2 = null;
		@Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	objetivoDAO = ObjetivoDAO.getInstance();	
	    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id_agente = request.getParameter("id_agente");
		
		Long id = Long.parseLong(id_agente);
		
		objetivo = objetivoDAO.objetivoActual(id,1); 
		request.setAttribute("objetivo", objetivo);	
		
		objetivo2 = objetivoDAO.objetivoActual(id,2); 
		request.setAttribute("objetivo2", objetivo2);	
													// si el objeto coche contiene matricula
		
		request.getRequestDispatcher("objetivos.jsp").forward(request, response);
			
	}
}
	
	