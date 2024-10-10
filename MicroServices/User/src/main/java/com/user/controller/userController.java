package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.enity.userEntity;
import com.user.service.userService;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userService service;

	@GetMapping("/")
	public List<userEntity> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public userEntity getByID(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/")
	public userEntity save(@RequestBody userEntity e1) {
		return service.save(e1);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
}
