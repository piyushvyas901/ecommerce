package com.ecommerce.shoppingcart.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ecommerce.shopingcart.Billionaires;
import com.ecommerce.shopingcart.model.Category;
import com.ecommerce.shopingcart.model.OrderCart;
import com.ecommerce.shopingcart.model.ProductRowMapper;
import com.ecommerce.shopingcart.model.Products;
import com.ecommerce.shopingcart.model.UserInfoRowMapper;
import com.ecommerce.shopingcart.model.UserRegistration;

@Repository
public class EcommerceRepository {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Billionaires> getAllItems(){
        List<Billionaires> items = template.query(" select first_name,  last_name, career from billionaires",(result,rowNum)->new Billionaires(result.getString("first_name"),
                result.getString("last_name"),result.getString("career")));
        return items;
    }


	public List<Category> getAllCategories(){
        List<Category> items = template.query(" select category_id,  product_category  from category",(result,rowNum)->new Category(result.getInt("category_id"),
                result.getString("product_category")));
        return items;
    }
	


	public List<Products> getAllProducts(Integer categoryId){
		String sql = "";
		List<Products> products=null;
		if (null!=categoryId) {
			 sql ="select product_id,  category_id, product_name  from products where category_id = ?";
			  products = template.query(sql, new Object[] { categoryId } , new ProductRowMapper());
				
		} else {
			sql = "select product_id,  category_id, product_name  from products ";
			 products = template.query(sql, new ProductRowMapper());
			
		}
		 
		 
        return products;
    }
	
	

public int insert(OrderCart orderCart) {
    return template.update("insert into ORDERCART (order_id, product_id, date_of_order) " + "values(?,  ?, ?)",
        new Object[] {
        		orderCart.getOrderId(), orderCart.getProductId(), orderCart.getDateOfOrder()
        });
}


public Integer getId() {
	  Integer orderId = 0;  
	List<OrderCart> items = template.query(" select order_id,  product_id, date_of_order from ordercart order by order_id desc limit 1",(result,rowNum)->new OrderCart(result.getInt("order_id"),
              result.getInt("product_id"),result.getString("date_of_order")));
      if(!CollectionUtils.isEmpty(items)) {
    	  orderId = items.get(0).getOrderId();
      }
	  return orderId;
}



public List<UserRegistration> getAllAuthenticated(String username,String password){
	String sql = "";
	List<UserRegistration> userInfo=null;
	 MapSqlParameterSource parameters = new MapSqlParameterSource();
     parameters.addValue("first_name", username);
     parameters.addValue("password", password);

	
		 sql ="select first_name, last_name, password from userdetailsandinfo where first_name = ? and password = ?";
		 userInfo = template.query(sql, new Object[] { username,password },new UserInfoRowMapper());
			
	 
    return userInfo;
}

}
