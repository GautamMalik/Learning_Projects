package com.admin.pojo;

public class finalPojo {
	private productDetailsPojo productDetailsPojo;
	
	private product product;

	public finalPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public finalPojo(com.admin.pojo.productDetailsPojo productDetailsPojo, com.admin.pojo.product product) {
		super();
		this.productDetailsPojo = productDetailsPojo;
		this.product = product;
	}

	@Override
	public String toString() {
		return "finalPojo [productDetailsPojo=" + productDetailsPojo + ", product=" + product + "]";
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
