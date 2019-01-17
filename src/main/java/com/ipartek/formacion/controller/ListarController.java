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
import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.pojos.Coche;
import com.ipartek.formacion.pojos.Multa;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/privado/listar")
public class ListarController extends HttpServlet {
	
	//  lógica de serialización,
	private static final long serialVersionUID = 1L; 
	
	// consultas con procedimientos almacenados
	private static final String LISTADO_MULTAS = "listadoMultas.jsp";
	private static final String LISTADO_MULTAS_ANULAR = "listadoMultasAnuladas.jsp";

	//log 	
	private final static Logger LOG = Logger.getLogger(LoginController.class);

	// dao
	private static AgenteDAO agenteDAO = null;
	private static CocheDAO cocheDAO = null;  // nuevo

	// arry list
	private ArrayList<Multa> multas = null;
	private Coche coche = null;   // nuevo
		
	// metodo init para dao, objeto ...
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		agenteDAO = AgenteDAO.getInstance();
		multas = new ArrayList<Multa>();
		coche = new Coche();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// recojo parametros
		String operacion = request.getParameter("operacion"); // operacion para saber si multas activas o anuladas
		String id = request.getParameter("id");
	
		
		try {
			Long identificador = Long.parseLong(id);
   
			if (operacion.equals("0")) {  // si recibo parametro operacion 0 listo multas activas
			multas = agenteDAO.getMultas(identificador);
			request.setAttribute("multas", multas);
			request.getRequestDispatcher(LISTADO_MULTAS).forward(request, response);
			LOG.debug("Mostrando listado");
	        
			}else if (operacion.equals("1")) { // si recibo 1 listo multas anuladas
	        	multas = agenteDAO.getMultasAnuladas(identificador);
	        	
	        
	        	
	    		request.setAttribute("multas", multas);
	    	
	    		
	    		request.getRequestDispatcher(LISTADO_MULTAS_ANULAR).forward(request, response);
	    		LOG.debug("Mostrando listado");	
	        
			}else {  // si recibo cualquier otra cosa que no sea ni 1 ni 0
	        	request.getRequestDispatcher("/404.jsp").forward(request, response);	    		
	        }
		
		}catch(Exception e) {
			LOG.debug("Cambiado el parametro en la url");	
			request.getRequestDispatcher("/404.jsp").forward(request, response);
		}
	}

	// lo que me llege por doGet va doProcess
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// lo que me llege por doPost va doProcess
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
