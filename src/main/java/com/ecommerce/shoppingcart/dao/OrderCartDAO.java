package com.ecommerce.shoppingcart.dao;

import org.springframework.stereotype.Component;

import com.ecommerce.shopingcart.model.OrderCart;

@Component
public interface OrderCartDAO {

	 public OrderCart save(OrderCart orderCart);
	 
	 public boolean delete(Integer orderId);
}
