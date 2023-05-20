package com.pruebas.springboot.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.springboot.jpa.caseuse.CreateUser;
import com.pruebas.springboot.jpa.caseuse.DeleteUser;
import com.pruebas.springboot.jpa.caseuse.GetUser;
import com.pruebas.springboot.jpa.caseuse.UpdateUser;
import com.pruebas.springboot.jpa.entity.User;

@RestController
@RequestMapping("api/users")
public class UserRestController {
	//crear, leer , eliminar y actualizar
	private GetUser getUser;
	private CreateUser createUser;
	private DeleteUser deleteUser;
	private UpdateUser updateUser;
	
	
	public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser,UpdateUser updateUser) {
		this.getUser = getUser;
		this.createUser = createUser;
		this.deleteUser = deleteUser;
		this.updateUser = updateUser;
	}
	
	@GetMapping("/")
	List<User> get(){
		return getUser.getAll();
		
	}
	
	@PostMapping("/")
	ResponseEntity<User> newUser(@RequestBody User newUser){
		return new ResponseEntity<User>(createUser.save(newUser), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	ResponseEntity deleteUser(@PathVariable Long id) {
		deleteUser.remove(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping("/{id}")
	ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
		return new ResponseEntity<User>(updateUser.replace(newUser,id),HttpStatus.OK);
	}
	
	
	

}
