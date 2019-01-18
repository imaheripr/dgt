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
import com.ipartek.formacion.pojos.Multa;



@WebServlet("/privado/objetivos")
public class ObjetivosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
		private final static Logger LOG = Logger.getLogger(ObjetivosController.class);

		
		@Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    		
	    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		
		
	}
	

}
