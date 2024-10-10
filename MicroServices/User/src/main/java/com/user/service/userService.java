package com.user.service;

import java.util.List;

import com.user.enity.userEntity;

public interface userService {
	public List<userEntity> getAll();
	
	public userEntity getById(int id);
	
	public userEntity save(userEntity e1);
	
	public String delete(int id);
}
