package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.productEntity;
import com.product.pojo.productPojo;
import com.product.service.productService;

@RestController
@RequestMapping("/product")
public class productController {
	
	@Autowired
	private productService service;
	
	@GetMapping("/")
	private List<productEntity> get(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	private productPojo getByID(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/")
	private productPojo save(@RequestBody productPojo e1) {
		return service.save(e1);
	}
	
	@PutMapping("/{id}")
	private productPojo update(@RequestBody productPojo p1, @PathVariable int id) {
		return service.update(p1, id);
	}
	
	@DeleteMapping("/{id}")
	private String dalete(@PathVariable int id) {
		return service.delete(id);
	}
}	
