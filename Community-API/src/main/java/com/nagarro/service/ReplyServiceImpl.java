package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.QuestionRepository;
import com.nagarro.entity.QuestionEntity;
import com.nagarro.entity.RepliesEntity;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private QuestionRepository repo;

	@Override
	public QuestionEntity AddReply(int id, RepliesEntity e1) {
		QuestionEntity obj = repo.findById(id).get();
		  
		List<RepliesEntity> list = obj.getReplies();
		list.add(e1);
		obj.setReplies(list);
		
		repo.save(obj);
		return obj;
	}

	

}
