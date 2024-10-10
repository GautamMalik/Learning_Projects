package com.nagarro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class QuestionEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "date" , length = 10)
	private String date;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "title", length = 100 )
	private String title;
	
	@Column(name = "body" , length = 1000)
	private String body;
	
	@Column(name = "solved", nullable = false)
	private String solved;
	
	@OneToMany(targetEntity = RepliesEntity.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "qr_fk" , referencedColumnName = "id")
	private List<RepliesEntity> replies;

	public QuestionEntity() {}
		
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSolved() {
		return solved;
	}

	public void setSolved(String solved) {
		this.solved = solved;
	}

	public List<RepliesEntity> getReplies() {
		return replies;
	}

	public void setReplies(List<RepliesEntity> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "QuestionEntity [id=" + id + ", title=" + title + ", body=" + body + ", solved=" + solved + ", replies="
				+ replies + "]";
	}
	
	
}
