package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="blogcomment_s180396")
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int commentId;
@ManyToOne
private BlogPost blogpost;
@ManyToOne
private User commentBy;
private String commentTxt;
private Date commentedOn;
public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public BlogPost getBlogpost() {
	return blogpost;
}
public void setBlogpost(BlogPost blogpost) {
	this.blogpost = blogpost;
}
public User getCommentBy() {
	return commentBy;
}
public void setCommentBy(User commentBy) {
	this.commentBy = commentBy;
}
public String getCommentTxt() {
	return commentTxt;
}
public void setCommentTxt(String commentTxt) {
	this.commentTxt = commentTxt;
}
public Date getCommentedOn() {
	return commentedOn;
}
public void setCommentedOn(Date commentedOn) {
	this.commentedOn = commentedOn;
}
}
