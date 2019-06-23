package com.ecommerce.shoppingcart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopingcart.model.OrderCart;
import com.ecommerce.shoppingcart.dao.OrderCartDAO;

@Repository
public class OrderCartDAOImpl implements OrderCartDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String INSERT_SQL = "INSERT INTO ORDERCART(order_id,product_id,date_of_order) values(?,?,?)";
	
	
	@Override
	public OrderCart save(OrderCart orderCart) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, orderCart.getOrderId());
				ps.setInt(2, orderCart.getProductId());
				ps.setString(3, orderCart.getDateOfOrder());
				return ps;
			}
		}, holder);

		int newUserId = holder.getKey().intValue();
		orderCart.setOrderId(newUserId);
		return orderCart;
	
	}


public boolean delete(Integer orderId){
    String sql = "DELETE FROM ordercart WHERE order_id = ?";
    Object[] args = new Object[] {orderId};

    return jdbcTemplate.update(sql, args) == 1;
}


}
