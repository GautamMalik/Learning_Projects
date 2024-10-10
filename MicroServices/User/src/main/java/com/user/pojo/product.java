package com.user.pojo;

public class product {
	
	private int pId;
	
	private String p_name;
	
	private String brand;

	public product() {
		super();
	}

	public product(int pId, String p_name, String brand) {
		super();
		this.pId = pId;
		this.p_name = p_name;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "product [pId=" + pId + ", p_name=" + p_name + ", brand=" + brand + "]";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
