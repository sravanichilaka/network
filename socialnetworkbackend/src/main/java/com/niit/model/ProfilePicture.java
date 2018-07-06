package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="profilepicture_s180396")
public class ProfilePicture {
	@Id
	private String email;
	@Lob
	private byte[] image;
    public String getEmail(){
    		return email;
    }
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
