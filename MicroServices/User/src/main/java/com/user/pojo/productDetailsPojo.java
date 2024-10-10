package com.user.pojo;

public class productDetailsPojo {
	
	private int pId;
	
	private String size;
	
	private String Color;
	
	private int price;

	public productDetailsPojo() {
		super();
	}

	public productDetailsPojo(int pId, String size, String color, int price) {
		super();
		this.pId = pId;
		this.size = size;
		Color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "productDetailsPojo [pId=" + pId + ", size=" + size + ", Color=" + Color + ", price=" + price + "]";
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
	
	
}
