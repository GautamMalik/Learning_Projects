package com.nagarro.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, String>{
	
	public List<LoginEntity> findByEmail(String email);
	public List<LoginEntity> findByEmailAndPassword(String email,String password);

}
