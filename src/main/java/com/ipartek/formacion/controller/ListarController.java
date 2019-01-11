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
import com.ipartek.formacion.pojos.Multa;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/privado/listar")
public class ListarController extends HttpServlet {

	private static final int ID_AGENTE_PREDEFINIDO = 4;

	private static final String LISTADO_MULTAS = "listadoMultas.jsp";
	private static final String LISTADO_MULTAS_ANULAR = "listadoMultasAnuladas.jsp";

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);

	private static AgenteDAO agenteDAO = null;

	ArrayList<Multa> multas = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		agenteDAO = AgenteDAO.getInstance();
		multas = new ArrayList<Multa>();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operacion = request.getParameter("operacion");
        if (operacion.equals("0")) {
		multas = agenteDAO.getMultas(ID_AGENTE_PREDEFINIDO);
		request.setAttribute("multas", multas);
		request.getRequestDispatcher(LISTADO_MULTAS).forward(request, response);
		LOG.debug("Mostrando listado");
        }else if (operacion.equals("1")) {
        	multas = agenteDAO.getMultasAnuladas(ID_AGENTE_PREDEFINIDO);
    		request.setAttribute("multas", multas);
    		request.getRequestDispatcher(LISTADO_MULTAS_ANULAR).forward(request, response);
    		LOG.debug("Mostrando listado");	
        }
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
