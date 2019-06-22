package com.ecommerce.shopingcart.model;

public class Category {

	
	private int categoryId;
	private String productCategory;
	
	public Category() {
		
	}
	
	public Category(int categoryId, String productCategory) {
		super();
		this.categoryId = categoryId;
		this.productCategory = productCategory;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	
}
