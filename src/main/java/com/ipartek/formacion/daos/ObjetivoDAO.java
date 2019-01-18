package com.ipartek.formacion.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Objetivo;

public class ObjetivoDAO {

	// LOG PARA MENSAJES
		private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	
		private static ObjetivoDAO INSTANCE = null;
	
	
		//metodo constructor superclase
		private ObjetivoDAO() {
			super();
		}
		
		// instance/singleton
		public synchronized static ObjetivoDAO getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new ObjetivoDAO();
			}
			return INSTANCE;
		}
			

	private static final String SQL_MES_ACTUAL=
	"SELECT id_agente, fecha, numero_multas, importe FROM v_objetivos WHERE id_agente= ? AND mes = MONTH(now()) AND anyo=YEAR(now());";
	
	private static final String SQL_ANIO_ACTUAL=
	"SELECT id_agente, fecha ,  SUM(numero_multas) AS 'numero_multas', SUM(importe) AS 'importe' FROM v_objetivos WHERE id_agente= ?  AND anyo=YEAR(now());" ;
	
	private static final String SQL_HISTORICO=
	"SELECT id_agente, fecha , numero_multas, importe FROM v_objetivos WHERE id_agente= ?  AND anyo=2018;";
	
	private static final String SQL_SELECT_ANIO=
	"SELECT DISTINCT fecha from v_objetivos WHERE id_agente= ?;";
	
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4 AND mes = MONTH(now()) AND anyo=YEAR(now());
//	SELECT SUM(importe) AS 'importe', SUM(numero_multas) AS 'numero_multas' FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
//  SELECT DISTINCT anyo from v_objetivos WHERE id_agente=4;
	
	
	
	
	// row mapper para recoger parametros
		private Objetivo rowMapper(ResultSet rs) throws SQLException { 
			Objetivo registro = new Objetivo();
			registro.setId_agente(rs.getLong("id_agente"));
			registro.setFecha(rs.getDate("fecha"));
			registro.setNum_multas(rs.getInt("numero_multas"));
			registro.setImporte(rs.getInt("importe"));	

			return registro;
		}
	
	
	public ArrayList<Objetivo> selectAnyo(Long id_agente) {
		String sql = SQL_SELECT_ANIO;
		Objetivo o = null;
		ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					o = new Objetivo();
					o.setFecha(rs.getDate("fecha"));
					objetivos.add(o);
					
				}
			}

		} catch (Exception e) {
			LOG.fatal("selecAnyo:---> " + e);
		}
		LOG.debug("selecAnyo OK");
		return objetivos;
	}
	
	public Objetivo objetivoActual(Long id_agente, Integer i) {
		String sql = SQL_MES_ACTUAL;
		
		if(i==1) {
		sql = SQL_MES_ACTUAL;
		}else if(i==2) {
			sql = SQL_ANIO_ACTUAL;
		}
		
		
		Objetivo o = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					o = new Objetivo();
					o = rowMapper(rs);	
					
				}
			}

		} catch (Exception e) {
			LOG.fatal("objetivoMesActual:---> " + e);
		}
		LOG.debug("objetivoMesActual OK");
		return o;
	}
	
	
			
	public ArrayList<Objetivo> historico(Long id_agente) {
		String sql = SQL_HISTORICO;
		ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
		
		Objetivo o = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					o = new Objetivo();
					o = rowMapper(rs);
					objetivos.add(o);
					
				}
			}

		} catch (Exception e) {
			LOG.fatal("objetivoMesActual:---> " + e);
		}
		LOG.debug("objetivoMesActual OK");
		return objetivos;
	}
	
	
}
