package com.nagarro.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.service.LoginService;
import com.nagarro.service.QuestionService;

@RestController
public class StatsController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/stats")  // 0th index is users and 1st index is questions
	public ArrayList<Integer> get() {
		int a = loginService.getAllUsers().size();
		int b = questionService.getAll().size();
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(a);
		arr.add(b);
		return arr;
	}
}
