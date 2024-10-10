package com.productDetails.controller;

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

import com.productDetails.entity.ProductDetailsEntity;
import com.productDetails.services.productDetailsService;

@RestController
@RequestMapping("/productdetails")
public class productDetalisController {
	
	@Autowired
	private productDetailsService service;
	
	@GetMapping("/")
	public List<ProductDetailsEntity> get() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductDetailsEntity getByID(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/")
	public ProductDetailsEntity save(@RequestBody ProductDetailsEntity e1) {
		return service.save(e1);
	}
	
	@PutMapping("/{id}")
	public ProductDetailsEntity update(@RequestBody ProductDetailsEntity e1, @PathVariable int id) {
		return service.saveAndUpdate(e1,id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
}
