package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.entity.ResultEntity;

public interface ResultRepository extends JpaRepository<ResultEntity, Integer> {
	public List<ResultEntity> findByrollNumberAndDob(int rollNumber , String Dob);
}
