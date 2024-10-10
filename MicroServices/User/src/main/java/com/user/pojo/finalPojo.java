package com.user.pojo;

public class finalPojo {
	
	private productDetailsPojo productDetailsPojo;
	
	private product product;
	
	public finalPojo() {
		super();
	}
	public finalPojo(com.user.pojo.product product, productDetailsPojo productDetails) {
		super();
		this.product = product;
		this.productDetailsPojo = productDetails;
	}
	@Override
	public String toString() {
		return "finalPojo [product=" + product + ", productDetails=" + productDetailsPojo + "]";
	}
	public productDetailsPojo getProductDetailsPojo() {
		return productDetailsPojo;
	}
	public void setProductDetailsPojo(productDetailsPojo productDetailsPojo) {
		this.productDetailsPojo = productDetailsPojo;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	
	
	
	
}
