package com.ecommerce.shopingcart.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Products>{

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		
		products.setpId(rs.getInt("product_id"));
		products.setcId(rs.getInt("category_id"));
		products.setName(rs.getString("product_name"));
		products.setPrice(rs.getInt("price"));

		
		return products;
	
	}

}
