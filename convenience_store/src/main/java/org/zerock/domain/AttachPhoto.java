package org.zerock.domain;

import java.util.Date;

public class AttachPhoto {
	
	private String attach_photo_fullname;
	private Date regdate;
	private int product_review_id;
	private int collabo_review_id;
	private int user_review_id;
	
	public String getAttach_photo_fullname() {
		return attach_photo_fullname;
	}
	public void setAttach_photo_fullname(String attach_photo_fullname) {
		this.attach_photo_fullname = attach_photo_fullname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getProduct_review_id() {
		return product_review_id;
	}
	public void setProduct_review_id(int product_review_id) {
		this.product_review_id = product_review_id;
	}
	public int getCollabo_review_id() {
		return collabo_review_id;
	}
	public void setCollabo_review_id(int collabo_review_id) {
		this.collabo_review_id = collabo_review_id;
	}
	public int getUser_review_id() {
		return user_review_id;
	}
	public void setUser_review_id(int user_review_id) {
		this.user_review_id = user_review_id;
	}
	
	
	

}
