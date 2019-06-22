package com.ecommerce.shoppingcart.filter;

import java.util.Collections;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ecommerce.shopingcart.model.UserRegistration;
import com.ecommerce.shoppingcart.repository.EcommerceRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	 @Autowired
	 EcommerceRepository ecommerceRepo;

	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		if(!StringUtils.isNullOrEmpty(userName) && !StringUtils.isNullOrEmpty(password)) {
			List<UserRegistration> user = ecommerceRepo.getAllAuthenticated(userName, password);
			if (CollectionUtils.isEmpty(user)) {
				throw new  BadCredentialsException("External system authentication failed");
			}
			else {
				return new UsernamePasswordAuthenticationToken(userName,password,Collections.emptyList());
			}
		}
		return null;
}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	
	}

}
