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



@WebServlet("/privado/objetivo_agente")
public class ObjetivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
			private final static Logger LOG = Logger.getLogger(ObjetivoController.class);
	
	//VISTAS
		private static final String OBJETIVO_JSP = "objetivos.jsp";
		private static final String OBJETIVO_ANUALES_JSP = "anuales.jsp";
		private String vista;
	//parametros	
		private String op;	
		private Long id_agente;	
	//OPERACIONES
		public static final String OP_LISTAR = "1";// lista botones objetivos anuales y manuales
		public static final String OP_ANUALES = "2";// mostrar destalles anuales

		private static AgenteDAO agenteDAO = null;
		@Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	agenteDAO = agenteDAO.getInstance();
	    	
	    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (op) {
				case OP_LISTAR:
					ir(request);
					break;
				case OP_ANUALES:
					anuales(request);
					break;
			
			}
			
			
		}catch (Exception e) {
			LOG.error(e);	
			
			
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}
	
	
	private void ir(HttpServletRequest request) {
		request.setAttribute("mensaje", "Selecciona estadisticas anules o mensuales");
		vista = OBJETIVO_JSP;
	}	
	
	
	private void anuales(HttpServletRequest request) {
		ArrayList<Integer> anios = new ArrayList<Integer>();
		anios = agenteDAO.getYearMultasAgente(id_agente);
		request.setAttribute("anios", anios);
		vista = OBJETIVO_ANUALES_JSP;
	}	
	
	
	
	
	
	private void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");
		String id_agente1 = request.getParameter("id");
		try{id_agente= Long.parseLong(id_agente1);}
		catch(Exception e) {
			id_agente=null;
		}
		
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
	}

}
