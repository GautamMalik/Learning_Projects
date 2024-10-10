package com.nagarro.dto;

import com.nagarro.entity.QuestionEntity;

public class PostQuestion {
	private QuestionEntity question;

	public PostQuestion() {}
	
	public PostQuestion(QuestionEntity question) {
		super();
		this.question = question;
	}

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "PostQuestion [question=" + question + "]";
	}
	
	
	
	
}
