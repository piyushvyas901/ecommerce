package com.ecommerce.shopingcart.model;

public class OrderCart {

	private Integer orderId;
	private Integer productId;
	private String dateOfOrder;
	
	public OrderCart() {
		
	}
	
	public OrderCart(Integer orderId, Integer productId, String dateOfOrder) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.dateOfOrder = dateOfOrder;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OrderId" + this.orderId + "productId" + this.productId + "DateOfOrder" +this.dateOfOrder;
	}
	
	
	
}
