package com.ecommerce.shoppingcart.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityFilter extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider customAuthProvider;

	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	JWTRequestFilter jwtRequestFilter;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(customAuthProvider);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();

	/*	httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/authenticate").permitAll().
				anyRequest().authenticated().and().
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
		
		  httpSecurity.httpBasic().and().authorizeRequests() .
		  antMatchers("/getAllItems").permitAll().
		  antMatchers("/ecommerce/**","/authenticate/**").authenticated();
		  
		  // Add a filter to validate the tokens with every request
		  httpSecurity.addFilterBefore(jwtRequestFilter,
		  UsernamePasswordAuthenticationFilter.class);
		 
	}
}
