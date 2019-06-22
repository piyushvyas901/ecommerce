package com.ecommerce.shopingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopingcart.model.Category;
import com.ecommerce.shopingcart.model.Products;

@RestController
public class BillionariesController {

	 @Autowired
	 BillionairesRepository billionariesRepo;

	 @RequestMapping("/getAllItems")
	    @ResponseBody
	    public List<Billionaires> getAllItems(){
	        return billionariesRepo.getAllItems();
	    }

	 @RequestMapping("/getAllCategories")
	    @ResponseBody
	    public List<Category> getAllCategories(){
	        return billionariesRepo.getAllCategories();
	    }
	 


	 @RequestMapping("/getAllProducts")
	    @ResponseBody
	    public List<Products> getAllProducts(@RequestParam(value = "categoryId", required =false) Integer categoryId){
		 
	        return billionariesRepo.getAllProducts(categoryId);
	    }
}
