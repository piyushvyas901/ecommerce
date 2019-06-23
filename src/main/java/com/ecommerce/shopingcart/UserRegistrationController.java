package com.ecommerce.shopingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopingcart.model.UserRegistration;

@RestController
public class UserRegistrationController {

	@Autowired
	UserRegistrationRepository userRegistrationRepo;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> registerUser(@RequestBody UserRegistration userRegistration) {

		if (userRegistration.getFirstName() != null && userRegistration.getPassword() != null) {
			
			 Integer orderId = userRegistrationRepo.getUserId();
			 userRegistration.setId(orderId+1);
			 //OrderCart orderGeneratedId = orderCartDAO.save(orderCart);
			UserRegistration userInfoCreated = userRegistrationRepo.registerUser(userRegistration); 
			
			return new ResponseEntity<>( 
				      "Order id generated is " + userInfoCreated,  
				      HttpStatus.OK);
		}
		return new ResponseEntity<>( 
			      "Please provide unique username and password "  ,  
			      HttpStatus.CONFLICT);
	}

}

	