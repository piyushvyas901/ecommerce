package com.ecommerce.shopingcart.model;

public class Products {

	private int productId;
	private int categoryId;
	private String productName;
	
	public Products() {
		
	}
	
	public Products(int productId, int categoryId, String productName) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
}
