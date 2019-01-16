package com.ipartek.formacion.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Multa;

public class MultaDAO {
	private static MultaDAO INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(MultaDAO.class);


	private static final String SQL_INSERT = "{call multa_insert(?,?,?,?,?)}";
	private static final String SQL_UPDATE = "{call multa_update(?,?)}";
	
	private MultaDAO() {
		super();
	}

	public synchronized static MultaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultaDAO();
		}
		return INSTANCE;
	}

	public boolean insert(Multa multa, Agente agente) throws SQLException {

		boolean resul = false;
		String sql = SQL_INSERT;
		try (
				Connection conn = ConnectionManager.getConnection(); 
				CallableStatement cs = conn.prepareCall(sql);) {

			cs.setFloat(1, multa.getImporte());
			cs.setString(2, multa.getConcepto());
			cs.setLong(3, multa.getCoche().getId());
			cs.setLong(4, agente.getId());
		
			//parametro de salida
			cs.registerOutParameter(5, Types.INTEGER );

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				// conseguir id generado
				multa.setId( cs.getLong(5) );	
				resul = true;
				LOG.debug("coche insertado");
			}
			
		}
		return resul;
	}

	public boolean update(Multa m) throws SQLException {
		
		boolean resul = false;
		String sql = SQL_UPDATE;
		try (Connection conn = ConnectionManager.getConnection(); 
				CallableStatement cs = conn.prepareCall(sql);) {

		
			cs.setLong(1, m.getId());
			
			//parametro de salida
			cs.registerOutParameter(2, Types.INTEGER );
	
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				m.setId( cs.getLong(2) );	
				resul = true;
			}
		}
		return resul;

	}

	
}
