package com.nagarro.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.dao.LoginRepository;
import com.nagarro.entity.LoginEntity;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repo;

	public List<LoginEntity> getAllUsers() {
		return repo.findAll();
	}

	public List<LoginEntity> getByEmail(String email) {
		return repo.findByEmail(email);
	}

	public LoginEntity saveUser(LoginEntity e1) {
		return this.repo.save(e1);
	}

	@Override
	public List<LoginEntity> getByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

}
