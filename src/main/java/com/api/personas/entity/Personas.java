package com.api.personas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "personas")
public class Personas {

	@Id
	private String dni;

	@NotNull(message = "el valor no puede ser nulo o vacio")
	@Column(name = "nombres", length = 100, nullable = false)
	private String nombres;

	@NotNull(message = "el valor no puede ser nulo o vacio")
	@Column(name = "apellidos", length = 100, nullable = false)
	private String apellidos;

	@NotNull(message = "el valor no puede ser nulo o vacio")
	@Column(name = "es_empleado", nullable = false)
	private boolean esEmpleado;

	public Personas() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

}
