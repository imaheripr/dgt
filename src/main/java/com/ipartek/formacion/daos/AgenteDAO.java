package com.ipartek.formacion.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Coche;
import com.ipartek.formacion.pojos.Multa;

public class AgenteDAO {

	private static final String SQL_GET_BY_ID = "{call agente_getById(?)}";
	private static final String SQL_ALL_MULTAS = "{call agente_getMultas(?)}";
	private static final String SQL_ALL_MULTAS_ANULADAS = "{call agente_getMultasAnuladas(?)}";
	private static final String SQL_LOGIN = "{call agente_login(?,?)}";
	
	private static AgenteDAO INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	

	private AgenteDAO() {
		super();
	}

	public synchronized static AgenteDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteDAO();
		}
		return INSTANCE;
	}

	private Agente rowMapper(ResultSet rs) throws SQLException {
		Agente registro = new Agente();
		registro.setId(rs.getLong("id"));
		registro.setApellido(rs.getString("nombre"));
		registro.setPlaca(rs.getInt("placa"));

		return registro;
	}

	public Agente getById(long id) {

		Agente usuario = null; 									// objeto tipo Agente Pojo
		String sql = SQL_GET_BY_ID;							// consulta sql
		try (Connection conn = ConnectionManager.getConnection(); 
			CallableStatement cs = conn.prepareCall(sql);) {	// CREO OBJETO CONNECTION
			
			// parametro entrada
			cs.setLong(1, id); 									// RECOJO PARAMETROS Del formulario
			
			try (ResultSet rs = cs.executeQuery()) { 			// EJECUTAR SQL
				while (rs.next()) {								// RECORRER BASE DE DATOS MEDIANtE METODO RS.NEXT.
					usuario = rowMapper(rs);				
				}
			}
		} catch (Exception e) {
			LOG.fatal("getById:---> " + e);
		}
		LOG.debug("Agente_id encontrado");
		return usuario;

	}
	
	public ArrayList<Multa> getMultas(long id) {
		ArrayList<Multa> multas = new ArrayList<Multa>();
		String sql = SQL_ALL_MULTAS;	
		Multa multa = null;
		Coche coche = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					multa = new Multa();
					coche = new Coche();
					multa.setId(rs.getLong("id_multa"));
					coche.setId(rs.getLong("id_coche"));
					multa.setFecha(rs.getDate("fecha"));
					multa.setHora(rs.getTime("fecha"));
					multa.setImporte(rs.getFloat("importe"));
					multa.setConcepto(rs.getString("concepto"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setModelo(rs.getString("modelo"));
					coche.setKm(rs.getInt("km"));

					multa.setCoche(coche);
					multas.add(multa);

				}
			}

		} catch (Exception e) {
			LOG.fatal("getMultas:---> " + e);
		}
		LOG.debug("Listado multas OK");
		return multas;
	}

	public ArrayList<Multa> getMultasAnuladas(long id) {
		ArrayList<Multa> multas = new ArrayList<Multa>();
		String sql = SQL_ALL_MULTAS_ANULADAS;
		Multa multa = null;
		Coche coche = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				CallableStatement cs = conn.prepareCall(sql);) {
			
			//parametro entrada
			cs.setLong(1, id);
			
			try (ResultSet rs = cs.executeQuery()) { //
				while (rs.next()) {
					multa = new Multa();
					coche = new Coche();
					multa.setId(rs.getLong("id_multa"));
					coche.setId(rs.getLong("id_coche"));
					multa.setFecha(rs.getDate("fecha"));
					multa.setHora(rs.getTime("fecha"));
					multa.setImporte(rs.getFloat("importe"));
					multa.setConcepto(rs.getString("concepto"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setModelo(rs.getString("modelo"));
					coche.setKm(rs.getInt("km"));

					multa.setCoche(coche);
					multas.add(multa);

				}
			}

		} catch (Exception e) {
			LOG.fatal("getMultas:---> " + e);
		}
		LOG.debug("Listado multas OK");
		return multas;
	}
	
	
	
public Agente login (Integer placa, String pass) {
		
	Agente usuario = null;
		String sql = SQL_LOGIN;
		
		try ( Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(sql);) {
				
			// parametros entrada
				cs.setInt(1, placa);
				cs.setString(2, pass);	
				
					try ( ResultSet rs = cs.executeQuery() ){	
						
							while(rs.next()) { 						
								Agente registro = new Agente();
								registro.setId( rs.getLong("id"));
								registro.setApellido(rs.getString("nombre"));		
								registro.setPlaca( rs.getInt("placa"));
								registro.setPassword(rs.getString("password"));		
								return registro;								
							}						
					}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return usuario;
	}
	
	

}
