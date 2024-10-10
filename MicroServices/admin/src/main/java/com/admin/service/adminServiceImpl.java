package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.pojo.finalPojo;
import com.admin.pojo.product;

@Service
public class adminServiceImpl implements adminService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public product[] getAll() {
		
		return restTemplate.getForObject("http://PRODUCT-SERVICE/product/", product[].class);
	}

	@Override
	public finalPojo getById(int id) {
		String i = String.valueOf(id);
		return restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+i,finalPojo.class);
	}

	@Override
	public finalPojo save(finalPojo e1) {
		restTemplate.postForEntity("http://PRODUCT-SERVICE/product/", e1, finalPojo.class);
		return e1;
	}

	@Override
	public finalPojo update(finalPojo e1, int id) {
		String i = String.valueOf(id);
		restTemplate.put("http://PRODUCT-SERVICE/product/"+i, e1);
		return e1;
	}

	@Override
	public String delete(int id) {
		String i = String.valueOf(id);
		restTemplate.delete("http://PRODUCT-SERVICE/product/"+i);
		return "deleted";
	}
	
	
	
}
