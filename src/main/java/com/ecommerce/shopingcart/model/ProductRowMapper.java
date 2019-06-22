package com.ecommerce.shopingcart.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Products>{

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		
		products.setProductId(rs.getInt("product_id"));
		products.setCategoryId(rs.getInt("category_id"));
		products.setProductName(rs.getString("product_name"));
		
		return products;
	
	}

}
