package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.LoginEntity;
import com.nagarro.exception.ResourseNotFoundException;
import com.nagarro.services.LoginService;

@RestController
public class Login {

	@Autowired
	private LoginService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login")
	public List<LoginEntity> get() {
		return service.getAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login/{email}")
	public List<LoginEntity> getByEmail(@PathVariable String email) {
		List<LoginEntity> list = service.getByEmail(email);
		if (list.size() != 0)
			return list;
		else
			throw new ResourseNotFoundException("User not exist with email : " + email);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public String save(@RequestBody LoginEntity e1) {
		List<LoginEntity> list = service.getByEmail(e1.getEmail());
		if (list.size() == 0) {
			service.saveUser(e1);
			return "added";
		} else
			throw new ResourseNotFoundException("User not exist with email : " + e1.getEmail());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login/{email}/{password}")
	public List<LoginEntity> getUser(@PathVariable("email") String email,@PathVariable("password") String password) {
		List<LoginEntity> list = service.getByEmailAndPassword(email,password);
		if (list.size() != 0)
			return list;
		else
			throw new ResourseNotFoundException("User not exist");
	}
}
