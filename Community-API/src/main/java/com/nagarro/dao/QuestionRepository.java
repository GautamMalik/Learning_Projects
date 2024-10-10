package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nagarro.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer>{
	
	public List<QuestionEntity> findByAuthor(String author);
}
