package com.ipartek.formacion.pojos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Agente {

	private Long id;
	private String apellido;
	
	@NotNull
	private Integer placa;
	
	@NotEmpty
	private String password;

	
	
	
	public Agente() {
		super();
		this.id = -1L;
		this.apellido ="" ;
		this.placa = -1;
		this.password="Pa$$w0rd";
	}


	public Agente(Long id, String apellido, Integer placa, Integer id_departamento, String password) {
		this();
		setId(id);
		setApellido(apellido);
		setPlaca(placa);
		setPassword(password);
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Agente [id=" + id + ", apellido=" + apellido + ", placa=" + placa + ", password=" + password + "]";
	}

	


	
	
	
	
}
