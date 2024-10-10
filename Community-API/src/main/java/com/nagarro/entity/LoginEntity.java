package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class LoginEntity {
	
	@Id
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "firstName", length = 50)
	private String firstName;
	
	@Column(name = "lastName", length = 50)
	private String lastName;
	
	@Column(name = "password", length = 50)
	private String password;
	
	public LoginEntity() {}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "LoginEntity [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}
	
}
