package com.ipartek.formacion.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.ipartek.formacion.pojos.Coche;

public class ObjetivoDAO {

	private static final String SQL_MES_ACTUAL=
	"SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente= ? AND mes = MONTH(now()) AND anyo=YEAR(now());";
	
	private static final String SQL_ANIO_ACTUAL=
	"SELECT SUM(importe) AS 'importe', SUM(numero_multas) AS 'numero_multas' FROM v_objetivos WHERE id_agente= ?  AND anyo=YEAR(now());" ;
	
	private static final String SQL_HISTORICO=
	"SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente= ?  AND anyo= ?;";
	
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4 AND mes = MONTH(now()) AND anyo=YEAR(now());
//	SELECT SUM(importe) AS 'importe', SUM(numero_multas) AS 'numero_multas' FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
//	SELECT id_agente, anyo, mes, numero_multas, importe FROM v_objetivos WHERE id_agente=4  AND anyo=2018;
	
	
	public Coche getMatricula(String matricula) {
		String sql = SQL_GET_MATRICULA;
		Coche coche = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				CallableStatement cs = conn.prepareCall(sql);) {
						cs.setString(1, matricula);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					coche = new Coche();
					coche.setId(rs.getLong("id"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setModelo(rs.getString("modelo"));
					coche.setKm(rs.getInt("km"));
				}
			}

		} catch (Exception e) {
			LOG.fatal("getMultas:---> " + e);
		}
		LOG.debug("Listado multas OK");
		return coche;
	}
	
}
