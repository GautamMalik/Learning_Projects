package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.RepliesEntity;
import com.nagarro.service.ReplyService;

@RestController
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/reply/{id}")
	public String addReply(@PathVariable String id , @RequestBody RepliesEntity e1) {
		service.AddReply(Integer.parseInt(id), e1);
		return "updated";
	}

	
}
