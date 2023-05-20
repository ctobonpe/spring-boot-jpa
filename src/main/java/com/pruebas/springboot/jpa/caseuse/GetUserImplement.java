package com.pruebas.springboot.jpa.caseuse;

import java.util.List;

import com.pruebas.springboot.jpa.entity.User;
import com.pruebas.springboot.jpa.service.UserService;

public class GetUserImplement implements GetUser {
	
	private UserService userService;
	
	public GetUserImplement(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userService.getAllUsers();
	}

}
