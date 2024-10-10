package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.userRepository;
import com.user.enity.userEntity;

@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userRepository repo;

	@Override
	public userEntity getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public userEntity save(userEntity e1) {
		return repo.save(e1);
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted";
	}

	@Override
	public List<userEntity> getAll() {
		return repo.findAll();
	}
	
	
}
