package com.ecommerce.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopingcart.model.Category;
import com.ecommerce.shopingcart.model.OrderCart;
import com.ecommerce.shopingcart.model.Products;
import com.ecommerce.shoppingcart.dao.OrderCartDAO;
import com.ecommerce.shoppingcart.repository.EcommerceRepository;

@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {
	
	 @Autowired
	 EcommerceRepository ecommerceRepo;

	 @Autowired
	 OrderCartDAO orderCartDAO;

	 @RequestMapping("/getAllCategories")
	    @ResponseBody
	    public List<Category> getAllCategories(){
	        return ecommerceRepo.getAllCategories();
	    }
	 
	 @RequestMapping("/getAllProducts")
	    @ResponseBody
	    public List<Products> getAllProducts(@RequestParam(value = "categoryId", required =false) Integer categoryId){
		 
	        return ecommerceRepo.getAllProducts(categoryId);
	    }

	 @RequestMapping(value = "/addOrder" ,method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<String> getAllProductsPost(@RequestBody OrderCart orderCart){
		 
		 
		 Integer orderId = ecommerceRepo.getId();
			 orderCart.setOrderId(orderId+1);
			 OrderCart orderGeneratedId = orderCartDAO.save(orderCart);
			 return new ResponseEntity<>(
				      "Order id generated is " + orderGeneratedId, 
				      HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/deleteOrder/{orderId}" ,method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseEntity<String> deleteProducts(@PathVariable(value = "orderId") Integer orderId){
		 
		 
		 boolean status = orderCartDAO.delete(orderId);
			 return new ResponseEntity<>(
				      "Order id generated is " + status, 
				      HttpStatus.OK);
	    }

}