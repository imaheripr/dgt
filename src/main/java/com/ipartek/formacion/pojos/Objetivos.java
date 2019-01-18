package com.ipartek.formacion.pojos;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Objetivos {

	private Long id_agente;
	private Date fecha;
	private Time hora;
	private int num_multas ;  
	private float importe;
	
	public Objetivos() {
		super();
		this.id_agente = -1L;
		this.fecha = null;
		this.hora = null;
		this.num_multas = -1;
		this.importe = (float) 1;
	}

	
	
	public Objetivos(Long id_agente, Date fecha, Time hora, int num_multas, float importe) {
		this();
		setId_agente(id_agente);
		setFecha(fecha);
		setHora(hora);
		setNum_multas(num_multas);
		setImporte(importe);
	}



	public Long getId_agente() {
		return id_agente;
	}



	public void setId_agente(Long id_agente) {
		this.id_agente = id_agente;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Time getHora() {
		return hora;
	}



	public void setHora(Time hora) {
		this.hora = hora;
	}



	public int getNum_multas() {
		return num_multas;
	}



	public void setNum_multas(int num_multas) {
		this.num_multas = num_multas;
	}



	public float getImporte() {
		return importe;
	}



	public void setImporte(float importe) {
		this.importe = importe;
	}



	@Override
	public String toString() {
		return "Objetivos [id_agente=" + id_agente + ", fecha=" + fecha + ", hora=" + hora + ", num_multas="
				+ num_multas + ", importe=" + importe + "]";
	}



	

	


}