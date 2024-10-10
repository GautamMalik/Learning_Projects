package com.product.service;

import java.util.List;

import com.product.entity.productEntity;
import com.product.pojo.productPojo;

public interface productService {
	public List<productEntity> getAll();
	
	public productPojo getById(int id);
	
	public productPojo save(productPojo e1);
	
	public productPojo update(productPojo e1, int id);
	
	public String delete(int id);
}
