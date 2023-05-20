package com.pruebas.springboot.jpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pruebas.springboot.jpa.caseuse.GetUser;
import com.pruebas.springboot.jpa.caseuse.GetUserImplement;
import com.pruebas.springboot.jpa.service.UserService;

@Configuration
public class CaseUseConfiguration {
	
	
	@Bean
	GetUser getUser(UserService userService) {
		return new GetUserImplement(userService);
	}
	

}
