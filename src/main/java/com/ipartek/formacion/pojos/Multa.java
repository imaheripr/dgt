package com.ipartek.formacion.pojos;

import java.sql.Date;

public class Multa {

	private Long id;
	private Integer importe ;
	private String concepto;
	private Date fecha;
	private Coche coche;
	
	
	public Multa() {
		super();
		this.id = -1L;
		this.importe = -1;
		this.concepto = "";
		this.fecha = null;
		this.coche= new Coche();
	}
	
	public Multa(Long id, Integer importe, String concepto, Date fecha, Coche coche) {
		this();
		setId(id);
		setImporte(importe);
		setConcepto(concepto);
		setFecha(fecha);
		setCoche(coche);
	}

	
	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getImporte() {
		return importe;
	}


	public void setImporte(Integer importe) {
		this.importe = importe;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Multa [id=" + id + ", importe=" + importe + ", concepto=" + concepto + ", fecha=" + fecha + "]";
	}
	
	
	
}
