package com.ipartek.formacion.daos;

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

	private static final String SQL_GET_BY_ID = "SELECT id, nombre, placa, id_departamento FROM agente WHERE id = ?;";
	private static final String SQL_ALL_MULTAS = "SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=? AND m.fecha_baja IS NULL ORDER BY m.fecha DESC ";
	private static final String SQL_ALL_MULTAS_ANULADAS = "SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=? AND m.fecha_baja IS NOT NULL ORDER BY m.fecha DESC ";
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
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					multa = new Multa();
					coche = new Coche();
					multa.setId(rs.getLong("id_multa"));
					coche.setId(rs.getLong("id_coche"));
					multa.setFecha(rs.getDate("fecha"));
					multa.setHora(rs.getTime("fecha"));
					multa.setImporte(rs.getInt("importe"));
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
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					multa = new Multa();
					coche = new Coche();
					multa.setId(rs.getLong("id_multa"));
					coche.setId(rs.getLong("id_coche"));
					multa.setFecha(rs.getDate("fecha"));
					multa.setHora(rs.getTime("fecha"));
					multa.setImporte(rs.getInt("importe"));
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

}
