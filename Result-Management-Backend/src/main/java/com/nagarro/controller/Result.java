package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.entity.ResultEntity;
import com.nagarro.exception.BadRequestException;
import com.nagarro.exception.ResourseNotFoundException;
import com.nagarro.services.ResultService;

@RestController
public class Result {

	@Autowired
	private ResultService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/result")
	public List<ResultEntity> getAll() {
		return service.getAllResult();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/result/{id}")
	public ResultEntity getById(@PathVariable String id) {
		return service.getResultById(Integer.parseInt(id))
				.orElseThrow(() -> new ResourseNotFoundException("User not exist with id : " + id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/result/{id}/{dob}")
	public List<ResultEntity> getByIdAndDob(@PathVariable String id, @PathVariable String dob){
		List<ResultEntity> list = service.getResultByRollNumberAndDob(Integer.parseInt(id), dob);
		if(list.size()==0)
			throw new ResourseNotFoundException("User not exist given roll no and dob : " );
		return list;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/result")
	public String saveResult(@RequestBody ResultEntity e1) {
		Optional<ResultEntity> obj = service.getResultById(e1.getRollNumber());
		if (!obj.isEmpty())
			throw new ResourseNotFoundException("User not exist with roll no : " + e1.getRollNumber());

		service.saveAndUpdateResult(e1);
		return "added";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("result")
	public ResultEntity update(@RequestBody ResultEntity e1) {
		Optional<ResultEntity> obj = service.getResultById(e1.getRollNumber());
		if (obj.isEmpty())
			throw new ResourseNotFoundException("User does not exist");
		else {
			obj.get().setName(e1.getName());
			obj.get().setDob(e1.getDob());
			obj.get().setScore(e1.getScore());

			service.saveAndUpdateResult(obj.get());
			return e1;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/result/{id}")
	public String delete(@PathVariable String id) {
		 service.deleteResult(id);
		 return "deleted";
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/result/gg")
	public void bad() {
		throw new BadRequestException("asdaf");
	}
}
