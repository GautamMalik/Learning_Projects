package com.nagarro.services;

import java.util.List;
import java.util.Optional;
import com.nagarro.entity.ResultEntity;

public interface ResultService {
	public List<ResultEntity> getAllResult();

	public Optional<ResultEntity> getResultById(int id);

	public void saveAndUpdateResult(ResultEntity e1);

	public void deleteResult(String id);
	
	public List<ResultEntity> getResultByRollNumberAndDob(int rollNumber , String dob);
}
