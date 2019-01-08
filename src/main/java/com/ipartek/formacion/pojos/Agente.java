package com.ipartek.formacion.pojos;

public class Agente {

	private Long id;
	private String apellido;
	private Integer placa;
	
	
	
	public Agente() {
		super();
		this.id = id;
		this.apellido = apellido;
		this.placa = placa;
	}


	public Agente(Long id, String apellido, Integer placa, Integer id_departamento) {
		super();
		setId(id);
		setApellido(apellido);
		setPlaca(placa);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}


	@Override
	public String toString() {
		return "Agente [id=" + id + ", apellido=" + apellido + ", placa=" + placa + "]";
	}

	


	
	
	
	
}
