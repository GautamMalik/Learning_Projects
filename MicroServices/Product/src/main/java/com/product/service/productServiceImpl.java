package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.dao.productRepository;
import com.product.entity.productEntity;
import com.product.pojo.productDetailsPojo;
import com.product.pojo.productPojo;

@Service
public class productServiceImpl implements productService{
	
	@Autowired
	private productRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<productEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public productPojo getById(int id) {
		String i = String.valueOf(id);
		productDetailsPojo details=restTemplate.getForObject("http://PRODUCT-DETAIL-SERVICE/productdetails/"+i, productDetailsPojo.class);
		productEntity obj= repo.findById(id).get();
		
		productPojo pojo = new productPojo();
		
		pojo.setProductDetailsPojo(details);
		pojo.setProduct(obj);
		
		return pojo;
		
	}

	@Override
	public productPojo save(productPojo p1) {
		repo.save(p1.getProduct());
		restTemplate.postForEntity("http://PRODUCT-DETAIL-SERVICE/productdetails/", p1.getProductDetailsPojo(), productDetailsPojo.class);
		
		return p1;
	}

	@SuppressWarnings("null")
	@Override
	public productPojo update(productPojo p1, int id) {
		
		productEntity obj = repo.findById(id).get();
		obj.setP_name(p1.getProduct().getP_name());
		obj.setBrand(p1.getProduct().getBrand());
		
		String i = String.valueOf(id);
		
		productDetailsPojo details=restTemplate.getForObject("http://PRODUCT-DETAIL-SERVICE/productdetails/"+i, productDetailsPojo.class);
		details.setColor(p1.getProductDetailsPojo().getColor());
		details.setPrice(p1.getProductDetailsPojo().getPrice());
		details.setSize(p1.getProductDetailsPojo().getSize());
		
		repo.save(obj);
		restTemplate.postForEntity("http://PRODUCT-DETAIL-SERVICE/productdetails/", details, productDetailsPojo.class);
		
		return p1;
	}

	@Override
	public String delete(int id) {
		String i = String.valueOf(id);
		repo.deleteById(id);
		restTemplate.exchange("http://PRODUCT-DETAIL-SERVICE/productdetails/" + i, HttpMethod.DELETE, null, String.class);
		return "deleted";
	}
}
