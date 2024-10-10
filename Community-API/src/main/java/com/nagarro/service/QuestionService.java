package com.nagarro.service;

import java.util.List;

import com.nagarro.dto.PostQuestion;
import com.nagarro.entity.QuestionEntity;

public interface QuestionService {
	public List<QuestionEntity> getAll();
	
	public QuestionEntity getByID(int id); 
	
	public List<QuestionEntity> getByAuthor(String author);
	
	public QuestionEntity saveQuestion(PostQuestion e1);
	
	public QuestionEntity update(PostQuestion e1);
	
	public QuestionEntity MarkAsSolved(int id);
}
