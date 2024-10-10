package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.dto.PostQuestion;
import com.nagarro.entity.QuestionEntity;
import com.nagarro.service.QuestionServiceImpl;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/question")
	public List<QuestionEntity> getAll() {
		return service.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/question/{id}")
	public QuestionEntity getByID(@PathVariable String id) {
		return service.getByID(Integer.parseInt(id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/question")
	public String saveQuestion(@RequestBody PostQuestion e1) {
		service.saveQuestion(e1);
		return "added";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/author/{author}")
	public List<QuestionEntity> lo(@PathVariable String author){
		return service.getByAuthor(author);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/question/{id}")
	public void markAsSolved(@PathVariable String id) {
		service.MarkAsSolved(Integer.parseInt(id));	
	}
	
}
