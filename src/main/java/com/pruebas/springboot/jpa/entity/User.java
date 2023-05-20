package com.pruebas.springboot.jpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//agrego que el valor del id sea geenrado automaticamente
	@Column(name = "id_user", nullable = false, unique = true)//asocio al nombre de una comuna de la db, que no sea nulo y que sea unico
	private Long id;
	
	@Column(name = "name", length = 50)
	private String nombre;
	
	@Column(length = 50, unique = true)
	private String email;
	
	@Column(name = "birth_date")
	private LocalDate fechaCumpleanios;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)//esto es para la clave foranea, pone en cascada para todas la spoeraciones y el tipo de busqueda fetch 
	@JsonManagedReference //para que no nos de error de stack over flow cuando se consuma mediante REST
	@JsonIgnore
	private List<Post> posts = new ArrayList<>();
	
	public User() {
		
	}
	
	
	public User(Long id) {
		this.id = id;
	}
	

	public User(String nombre, String email, LocalDate fechaCumpleanios) {
		this.nombre = nombre;
		this.email = email;
		this.fechaCumpleanios = fechaCumpleanios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaCumpleanios() {
		return fechaCumpleanios;
	}

	public void setFechaCumpleanios(LocalDate fechaCumpleanios) {
		this.fechaCumpleanios = fechaCumpleanios;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", email=" + email + ", fechaCumpleanios=" + fechaCumpleanios
				+ ", posts=" + posts + "]";
	}	
}
