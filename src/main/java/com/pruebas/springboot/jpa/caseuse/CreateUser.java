package com.pruebas.springboot.jpa.caseuse;

import org.springframework.stereotype.Component;

import com.pruebas.springboot.jpa.entity.User;
import com.pruebas.springboot.jpa.service.UserService;

@Component
public class CreateUser {
	
	private UserService userService;
	
	public CreateUser(UserService userService) {
		
		this.userService = userService;
		
	}
	
	public User save(User newUser) {
		return userService.save(newUser);
	}
	

}
