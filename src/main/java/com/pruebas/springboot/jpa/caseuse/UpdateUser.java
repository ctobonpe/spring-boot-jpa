package com.pruebas.springboot.jpa.caseuse;

import org.springframework.stereotype.Component;

import com.pruebas.springboot.jpa.entity.User;
import com.pruebas.springboot.jpa.service.UserService;

@Component
public class UpdateUser {
	
	private UserService userService;
	
	public UpdateUser(UserService userService) {
		
		this.userService = userService;
		
	}

	public User replace(User newUser, Long id) {
		return userService.update(newUser,id);
		
	}
	

}
