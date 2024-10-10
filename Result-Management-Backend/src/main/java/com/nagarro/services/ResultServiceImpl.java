package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.ResultRepository;
import com.nagarro.entity.ResultEntity;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository repo;

	@Override
	public List<ResultEntity> getAllResult() {
		return repo.findAll();
	}

	@Override
	public Optional<ResultEntity> getResultById(int id) {
		return repo.findById(id);
	}

	@Override
	public void saveAndUpdateResult(ResultEntity e1) {
		repo.save(e1);
	}

	@Override
	public void deleteResult(String id) {
		repo.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public List<ResultEntity> getResultByRollNumberAndDob(int rollNumber, String dob) {
		return repo.findByrollNumberAndDob(rollNumber, dob);
		
	}

}
