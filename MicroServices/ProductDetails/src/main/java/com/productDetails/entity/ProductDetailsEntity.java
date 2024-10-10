package com.productDetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductDetails")
public class ProductDetailsEntity {
	
	@Id
	@Column(name = "ID",nullable = false)
	private int pId;
	
	@Column(name = "Size", nullable = false , length = 50)
	private String size;
	
	@Column(name = "Color", nullable = false , length = 50)
	private String Color;
	
	@Column(name = "Price", nullable = false , length = 50)
	private int price;


	public ProductDetailsEntity() {
		super();
	}

	public ProductDetailsEntity(int pId, String size, String color, int price) {
		super();
		this.pId = pId;
		this.size = size;
		Color = color;
		this.price = price;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDetailsEntity [pId=" + pId + ", size=" + size + ", Color=" + Color + "]";
	}
	
}
