package com.productDetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productDetails.dao.productDetailsRepository;
import com.productDetails.entity.ProductDetailsEntity;

@Service
public class productDetailsServiceImpl implements productDetailsService{
	
	@Autowired
	private productDetailsRepository repo;
	
	@Override
	public List<ProductDetailsEntity> getAll() {
		return repo.findAll();
		
	}

	@Override
	public ProductDetailsEntity getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public ProductDetailsEntity save(ProductDetailsEntity e1) {
		return repo.save(e1);
	}

	@Override
	public ProductDetailsEntity saveAndUpdate(ProductDetailsEntity e1, int id) {
		ProductDetailsEntity obj = repo.findById(id).get();
		obj.setColor(e1.getColor());
		obj.setPrice(e1.getPrice());
		obj.setSize(e1.getSize());
		return repo.save(obj);
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "deleted";
	}

}
