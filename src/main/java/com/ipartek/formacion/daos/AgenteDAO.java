package com.ipartek.formacion.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Multa;

public class AgenteDAO {

	
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, placa, id_departamento FROM agente WHERE id = ?;";
	private static final String SQL_ALL_MULTAS =
	"SELECT multa.id AS 'id_multa', importe, concepto, fecha FROM agente, multa WHERE agente.id=multa.id_agente AND agente.id=?" 
	;
	
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
		registro.setId( rs.getLong("id"));
		registro.setApellido( rs.getString("nombre"));
		registro.setPlaca( rs.getInt("placa"));
		
		return registro;
	}
	
	
	
	public Agente getById(long id) {

		Agente usuario = null;
		String sql = SQL_GET_BY_ID;
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { 
					usuario = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return usuario;
	}
	
	public ArrayList<Multa> getMultas(long id){
		ArrayList<Multa> multas = new ArrayList<Multa>();
		String sql = SQL_ALL_MULTAS;	
		Multa multa = null;
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while(rs.next()) { 	
					multa = new Multa();
					multa.setId( rs.getLong("id_multa"));
						multa.setImporte( rs.getInt("importe"));
						multa.setConcepto( rs.getString("concepto"));
						multa.setFecha( rs.getString("fecha"));
						multas.add(multa);
			
				} 	
			}
			
		}catch (Exception e) {
			LOG.debug(e);
		}
		return multas;
	}
	
	
	

}
