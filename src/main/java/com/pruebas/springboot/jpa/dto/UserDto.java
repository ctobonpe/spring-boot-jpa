package com.pruebas.springboot.jpa.dto;

import java.time.LocalDate;

public class UserDto {
	
	private Long id;
	private String nombre;
	private LocalDate fechaCumpleanios;
	
	public UserDto(Long id, String name, LocalDate fechaCumpleanios) {
		this.id = id;
		this.nombre = name;
		this.fechaCumpleanios = fechaCumpleanios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public LocalDate getFechaCumpleanios() {
		return fechaCumpleanios;
	}

	public void setFechaCumpleanios(LocalDate fechaCumpleanios) {
		this.fechaCumpleanios = fechaCumpleanios;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + nombre + ", fechaCumpleanios=" + fechaCumpleanios + "]";
	}
	
	
	

}
