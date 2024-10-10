package com.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.user.pojo.finalPojo;
import com.user.pojo.product;

@Service
public class productServiceImpl implements productService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public product[] getAll() {
		product[] response = restTemplate.getForObject("http://PRODUCT-SERVICE/product/",product[].class);
		return response;
		
	}

	@Override
	public finalPojo getById(int id) {
		String i = String.valueOf(id);
		return restTemplate.getForObject("http://PRODUCT-SERVICE/product/" + i, finalPojo.class);

	}

}
