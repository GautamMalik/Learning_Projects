package com.product.pojo;

import com.product.entity.productEntity;

public class productPojo {
	private productDetailsPojo productDetailsPojo;
	
	private productEntity product;

	public productPojo() {
		super();
	}

	public productPojo(com.product.pojo.productDetailsPojo productDetailsPojo, productEntity product) {
		super();
		this.productDetailsPojo = productDetailsPojo;
		this.product = product;
	}

	@Override
	public String toString() {
		return "productPojo [productDetailsPojo=" + productDetailsPojo + ", product=" + product + "]";
	}

	public productDetailsPojo getProductDetailsPojo() {
		return productDetailsPojo;
	}

	public void setProductDetailsPojo(productDetailsPojo productDetailsPojo) {
		this.productDetailsPojo = productDetailsPojo;
	}

	public productEntity getProduct() {
		return product;
	}

	public void setProduct(productEntity product) {
		this.product = product;
	}
	
	
}
