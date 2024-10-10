package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.pojo.finalPojo;
import com.user.pojo.product;
import com.user.service.productService;

@RestController
@RequestMapping("/user/product/")
public class ProductController {
	
	@Autowired
	private productService ser;
	
	
	@GetMapping("/")
	public product[] getAll() {
		return ser.getAll();
	}
	
	@GetMapping("/{id}")
	public finalPojo get(@PathVariable int id) {
		return ser.getById(id);
	}
}
