package com.ipartek.formacion.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.pojos.Agente;

public class AgenteDAO {

	
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, placa, id_departamento FROM agente WHERE id = ?;";
	private static AgenteDAO INSTANCE = null;
	
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
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	

}
