package com.abir.project.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue
	private long id;
	private String text;
	private Boolean isPublicPost;
	@OneToOne
	private User user;
	@OneToOne
	private Location location;
	
	public Posts() {
		super();
	}

	public Posts(long id, String text, Boolean isPublicPost, User user, Location location) {
		super();
		this.id = id;
		this.text = text;
		this.isPublicPost = isPublicPost;
		this.user = user;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsPublicPost() {
		return isPublicPost;
	}

	public void setIsPublicPost(Boolean isPublicPost) {
		this.isPublicPost = isPublicPost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
