package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="blogpost_s180396")

public class BlogPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String blogTittle;
	@Lob
	private String blogcontent;
	private Date PostedOn;
	@ManyToOne
	private User PostedBy;
	private boolean approved;
	private int likes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlogTittle() {
		return blogTittle;
	}
	public void setBlogTittle(String blogTittle) {
		this.blogTittle = blogTittle;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
	public Date getPostedOn() {
		return PostedOn;
	}
	public void setPostedOn(Date postedOn) {
		PostedOn = postedOn;
	}
	public User getPostedBy() {
		return PostedBy;
	}
	public void setPostedBy(User postedBy) {
		PostedBy = postedBy;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	

}
