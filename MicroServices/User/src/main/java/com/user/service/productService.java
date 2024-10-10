package com.user.service;

import com.user.pojo.finalPojo;
import com.user.pojo.product;

public interface productService {
	
	public product[] getAll();
	public finalPojo getById(int id);
}
