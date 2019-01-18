package com.ipartek.formacion.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

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
	"SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente= ? AND mes = MONTH(now()) AND anyo=YEAR(now());";
	
	private static final String SQL_ANIO_ACTUAL=
	"SELECT SUM(importe) AS 'importe', SUM(numero_multas) AS 'numero_multas' FROM v_objetivos WHERE id_agente= ?  AND anyo=YEAR(now());" ;
	
	private static final String SQL_HISTORICO=
	"SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente= ?  AND anyo= ?;";
	
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4 AND mes = MONTH(now()) AND anyo=YEAR(now());
//	SELECT SUM(importe) AS 'importe', SUM(numero_multas) AS 'numero_multas' FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
	
	
	public Objetivo objetivoMesActual(Long id_agente) {
		String sql = SQL_MES_ACTUAL;
		Objetivo o = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id_agente);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					o = new Objetivo();
					o.setId_agente(rs.getLong("id_agente"));
					o.setFecha(rs.getDate("anyo"));
					o.setFecha(rs.getDate("mes"));
					o.setNum_multas(rs.getInt("numero_multas"));
					o.setImporte(rs.getInt("importe"));
				}
			}

		} catch (Exception e) {
			LOG.fatal("objetivoMesActual:---> " + e);
		}
		LOG.debug("objetivoMesActual OK");
		return o;
	}
	
}
