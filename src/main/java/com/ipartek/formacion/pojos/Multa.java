package com.ipartek.formacion.pojos;


public class Multa {
	
	private Long id;
	private Integer importe ;
	private String concepto;
	private String fecha;
	
	public Multa() {
		super();
		this.id = -1L;
		this.importe = -1;
		this.concepto = "";
		this.fecha = "";
	}
	
	public Multa(Long id, Integer importe, String concepto, String fecha) {
		this();
		setId(id);
		setImporte(importe);
		setConcepto(concepto);
		setFecha(fecha);
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


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Multa [id=" + id + ", importe=" + importe + ", concepto=" + concepto + ", fecha=" + fecha + "]";
	}
	
	
	
}
