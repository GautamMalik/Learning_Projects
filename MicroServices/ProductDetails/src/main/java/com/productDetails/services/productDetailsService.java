package com.productDetails.services;

import java.util.List;

import com.productDetails.entity.ProductDetailsEntity;

public interface productDetailsService {
	public List<ProductDetailsEntity> getAll();
	
	public ProductDetailsEntity getById(int id);
	
	public ProductDetailsEntity save(ProductDetailsEntity e1);
	
	public ProductDetailsEntity saveAndUpdate(ProductDetailsEntity e1, int id);
	
	public String delete(int id);
}
