package org.zerock.domain;

import java.util.Date;

public class AttachPhoto {
	
	private String attach_photo_fullname;
	private Date regdate;
	private ProductReview productReview;
	private CollaboReview collaboReview;
	private UserReview userReview;
	
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
	public ProductReview getProductReview() {
		return productReview;
	}
	public void setProductReview(ProductReview productReview) {
		this.productReview = productReview;
	}
	public CollaboReview getCollaboReview() {
		return collaboReview;
	}
	public void setCollaboReview(CollaboReview collaboReview) {
		this.collaboReview = collaboReview;
	}
	public UserReview getUserReview() {
		return userReview;
	}
	public void setUserReview(UserReview userReview) {
		this.userReview = userReview;
	}

}
