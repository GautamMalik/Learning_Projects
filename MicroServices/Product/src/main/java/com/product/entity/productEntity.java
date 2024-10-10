package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class productEntity {
	
	@Id
	@Column(name = "ID",nullable = false)
	private int pId;
	
	@Column(name = "p_name" , nullable = false, length= 50)
	private String p_name;
	
	@Column(name = "brand" ,nullable = false, length = 50)
	private String brand;

	public productEntity() {
		super();
	}

	public productEntity(int pId, String p_name, String brand) {
		super();
		this.pId = pId;
		this.p_name = p_name;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "productEntity [pId=" + pId + ", p_name=" + p_name + ", brand=" + brand + "]";
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
