package com.pruebas.springboot.jpa.caseuse;

import java.util.List;

import com.pruebas.springboot.jpa.entity.User;

public interface GetUser {
	
	List<User> getAll();

}
