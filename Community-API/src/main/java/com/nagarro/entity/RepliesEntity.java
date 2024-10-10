package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepliesEntity {
	
	@Id
	@Column(name = "subject" , length = 100)
	private String subject;
	
	@Column(name="body" , length = 1000)
	private String body;

	public RepliesEntity() {}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "RepliesEntity [subject=" + subject + ", body=" + body + "]";
	}
		
}
