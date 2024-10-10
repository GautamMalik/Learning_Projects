package com.nagarro.services;

import java.util.List;
import com.nagarro.entity.LoginEntity;

public interface LoginService {
	public List<LoginEntity> getAllUsers();

	public List<LoginEntity> getByEmail(String email);

	public LoginEntity saveUser(LoginEntity e1);
	
	public List<LoginEntity> getByEmailAndPassword(String email ,String password);
}
