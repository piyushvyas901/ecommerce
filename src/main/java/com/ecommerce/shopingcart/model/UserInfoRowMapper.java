package com.ecommerce.shopingcart.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserInfoRowMapper implements RowMapper<UserRegistration>{

	@Override
	public UserRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserRegistration user = new UserRegistration();
		user.setId(rs.getInt("id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}

}
