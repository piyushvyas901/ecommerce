package com.ecommerce.shopingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopingcart.model.Category;
import com.ecommerce.shopingcart.model.ProductRowMapper;
import com.ecommerce.shopingcart.model.Products;

@Repository
public class BillionairesRepository {

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
	
	
	
}
