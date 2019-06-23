package com.ecommerce.shopingcart.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.shopingcart.UserRegistrationRepository;
import com.ecommerce.shopingcart.model.UserRegistration;

@Service
public class JWTUserDetailsService {

	@Autowired
	private UserRegistrationRepository userRegistrationrRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserRegistration userRegister = userRegistrationrRepository.getAllAuthenticated(username);
		User user = null;
		if (Objects.nonNull(userRegister)) {
			return new User(userRegister.getFirstName(),
					userRegister.getPassword(),true , true, true, true, getAuthorities("ROLE_USER"));
		}
		return null;
	}
	
	  private Collection<? extends GrantedAuthority> getAuthorities(String role) {
          return Arrays.asList(new SimpleGrantedAuthority(role));
   }

}
