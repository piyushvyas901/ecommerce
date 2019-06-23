package com.ecommerce.shopingcart.model;

public class UserRegistration {

	private Integer id;
	private String firstName;
	private String lastName;
	private String password;
	
	public UserRegistration() {
		
	}
	
	
	public UserRegistration(Integer id, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return "User " + this.firstName + " " + this.lastName + " " + "generated successfully";
	}
	
	
}
