package com.pruebas.springboot.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "POSTS")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//agrego que el valor del id sea genrado
	@Column(name = "id_post", nullable = false, unique = true)//asocio al nombre de una comuna de la db, que no sea nulo y que sea unico
	private Long id;
	@Column(name = "description", length = 255)
	private String description;

	
	@ManyToOne
	private User user;
	
	public Post() {
		
	}

	public Post(Long id, String description, User user) {
		this.description = description;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", user=" + user + "]";
	}
	
	
	
	
}
