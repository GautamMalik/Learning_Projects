package com.user.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class userEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "user_name",length = 30)
	private String user_name;
	
	@Column(name = "email",length = 30)
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public userEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userEntity(int id, String user_name, String email) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "userEntity [id=" + id + ", user_name=" + user_name + ", email=" + email + "]";
	}
	
	
	
}
