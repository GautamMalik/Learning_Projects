package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.pojo.finalPojo;
import com.admin.pojo.product;
import com.admin.service.adminService;

@RestController
@RequestMapping("/admin/product")
public class adminController {
	
	@Autowired
	private adminService service;
	
	@GetMapping("/")
	public product[] getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public finalPojo getByID(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/")
	public finalPojo save(@RequestBody finalPojo e1) {
		return service.save(e1);
	}
	
	@PutMapping("/{id}")
	public finalPojo update(@PathVariable int id, @RequestBody finalPojo e1) {
		return service.update(e1, id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
}
