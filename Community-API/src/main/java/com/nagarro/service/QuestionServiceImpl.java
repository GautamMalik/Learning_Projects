package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.QuestionRepository;
import com.nagarro.dto.PostQuestion;
import com.nagarro.entity.QuestionEntity;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public List<QuestionEntity> getAll() {
		return this.questionRepo.findAll();
	}

	@Override
	public QuestionEntity saveQuestion(PostQuestion e1) {
		return this.questionRepo.save(e1.getQuestion());
	}

	@Override
	public QuestionEntity getByID(int id) {
		return questionRepo.findById(id).get();
	}
	

	@Override
	public QuestionEntity update(PostQuestion e1) {
		  QuestionEntity obj = questionRepo.findById(e1.getQuestion().getId()).get();
		 
		  obj.setTitle(e1.getQuestion().getTitle());
		  obj.setBody(e1.getQuestion().getBody());
		  obj.setSolved(e1.getQuestion().getSolved());
		  obj.setReplies(e1.getQuestion().getReplies());		  
		  
		  return questionRepo.save(obj);
	}

	@Override
	public List<QuestionEntity> getByAuthor(String author) {
		return questionRepo.findByAuthor(author);
	}
	
	@Override
	public QuestionEntity MarkAsSolved(int id) {
		QuestionEntity obj = questionRepo.findById(id).get();
		
		obj.setSolved("true");
		questionRepo.save(obj);
		return obj;
	}
}
