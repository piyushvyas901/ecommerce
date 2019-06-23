package com.ecommerce.shopingcart.model;

public class Category {

	
	private int cId;
	private String name;
	
	public Category() {
		
	}

	public Category(int cId, String name) {
		super();
		this.cId = cId;
		this.name = name;
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
	
	
	
}
