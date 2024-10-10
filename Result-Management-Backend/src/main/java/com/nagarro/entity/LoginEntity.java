package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_tbl")
public class LoginEntity {
	
	@Id
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="password" , length = 50)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginEntity() {
		super();
	}

	@Override
	public String toString() {
		return "LoginEntity [email=" + email + ", password=" + password + "]";
	}
	
}
