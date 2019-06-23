package com.ecommerce.shopingcart.model;

public class Products {

	private int pId;
	private int cId;
	private String name;
	private int price;
	
	public Products() {
		
	}
	
	public Products(int pId, int cId, String name, int price) {
		super();
		this.pId = pId;
		this.cId = cId;
		this.name = name;
		this.price = price;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
	
	
}
