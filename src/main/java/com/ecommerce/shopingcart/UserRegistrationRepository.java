package com.ecommerce.shopingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ecommerce.shopingcart.model.UserInfoRowMapper;
import com.ecommerce.shopingcart.model.UserRegistration;

@Repository
public class UserRegistrationRepository {

	@Autowired
	JdbcTemplate template;
	
	private final String INSERT_SQL = "INSERT INTO USERDETAILSANDINFO(id,first_name,last_name,password) values(?,?,?,?)";

	public UserRegistration registerUser(UserRegistration userRegistration){
		KeyHolder holder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, userRegistration.getId());
				ps.setString(2, userRegistration.getFirstName());
				ps.setString(3, userRegistration.getLastName());
				ps.setString(4, userRegistration.getPassword());
				return ps;
			}
		}, holder);

		int newUserId = holder.getKey().intValue();
		userRegistration.setId(newUserId);
		return userRegistration;

	}
	
	

	public Integer getUserId() {
		Integer orderId = 0;
		List<UserRegistration> items = template.query(
				" select id,  first_name, last_name , password from userdetailsandinfo order by id desc limit 1",
				(result, rowNum) -> new UserRegistration(result.getInt("id"), result.getString("first_name"),
						result.getString("last_name"),result.getString("password")));
		if (!CollectionUtils.isEmpty(items)) {
			orderId = items.get(0).getId();
		}
		return orderId;
	}
	

	public UserRegistration getAllAuthenticated(String username) {
		String sql = "";
		List<UserRegistration> userInfo = null;
		UserRegistration user= null;
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("first_name", username);

		sql = "select id, first_name, last_name, password from userdetailsandinfo where first_name = ? ";
		userInfo = template.query(sql, new Object[] { username }, new UserInfoRowMapper());

		if (!CollectionUtils.isEmpty(userInfo)) {
			user = userInfo.get(0);
		}
		return user;
	}
	
}
