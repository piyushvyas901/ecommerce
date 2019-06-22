package com.ecommerce.shopingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.ecommerce")

@ComponentScan({"com.ecommerce","com.ecommerce.shoppingcart.dao"})

@SpringBootApplication
//@ComponentScan({"com.ecommerce.shoppingcart.*"})
public class ShopingcartApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ShopingcartApplication.class, args);
	}


}
