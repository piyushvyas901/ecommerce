package com.ecommerce.shopingcart.model;

import java.io.Serializable;

public class JWTRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String firstName;
	private String password;

	public JWTRequest() {
	}

	public JWTRequest(String firstName, String password) {
		this.setFirstName(firstName);
		this.setPassword(password);
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}