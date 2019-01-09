package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.daos.MultaDAO;
import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Coche;
import com.ipartek.formacion.pojos.Multa;

@WebServlet("privado/multar")
public class MultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//LOG
	private final static Logger LOG = Logger.getLogger(MultaController.class);
	
	private ValidatorFactory factory;
	private Validator validator;
	
	//VISTAS
	private static final String VIEW_INDEX = "privado/principal.jsp";
	private static final String VIEW_FORM = "privado/multa.jsp";
	private String vista;
	 
	//OPERACIONES
	public static final String OP_INSERTAR = "1";
			

			
	//parametros	
	private String operacion;
	private String id_agente;
	private String id_coche;
	private String importe;
	private String concepto;
			
		
			
	private static MultaDAO MultaDAO = null;
	private static CocheDAO CocheDAO = null;
		    
private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vista = VIEW_INDEX;

		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (operacion) {
				case OP_INSERTAR:
					insertar(request);
					break;	
				
			}
			
			
		}catch (Exception e) {
			LOG.error(e);	
			
			
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);}
	
	
	
	
	
	private void insertar(HttpServletRequest request) {
		
		//crear pojos mediante parametros del formulario
		
		Coche coche = new Coche();
		int coche_id = Integer.parseInt(id_coche);
		coche.setId((long)coche_id);
		
		Multa multa = new Multa();
		multa.setImporte(Integer.parseInt(importe));
		multa.setConcepto(concepto);
		multa.setCoche(coche);
		
		
		
		Agente agente = new Agente();
		int agente_id = Integer.parseInt(id_agente);
		coche.setId((long)agente_id);
		
		//validar 		
		Set<ConstraintViolation<Multa>> violations = validator.validate(multa);
				
				
				if ( violations.size() > 0 ) {              // validacion NO correcta
					 
				 vista = VIEW_FORM; 
				 request.setAttribute("mensaje", "CAMPOS INCORRECTOS");	
				  
				}else {									  //  validacion correcta
				
					try {				
							MultaDAO.insert(multa,agente);
							request.setAttribute("mensaje", "Registro guardado con exito");
						
						
					}catch ( SQLException e) {
						request.setAttribute("mensaje", "Lo sentimos pero el codigo del video existe");
						
					}	
					
					
				}	
				
				
				
}
	
	
	
	
	
	
	
	
	
	
	
	
	private void getParametros(HttpServletRequest request) {
		operacion = request.getParameter("operacion");
		id_agente = request.getParameter("id_agente");
		id_agente = request.getParameter("id_coche");
		id_agente = request.getParameter("importe");
		id_agente = request.getParameter("concepto");
		LOG.debug( String.format("parametros: %,%,%,%,%", operacion, id_agente, id_coche, importe,concepto ));

		
	}

}
