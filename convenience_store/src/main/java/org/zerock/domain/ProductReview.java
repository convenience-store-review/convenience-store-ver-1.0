package org.zerock.domain;

import java.util.Date;

public class ProductReview {
	
	private int product_review_id;
	private int product_id;
	private int grage_id;
	private int like_count;
	private int grade_total_count;
	private Date regdate;
	private Date updatedate;
	
	public int getProduct_review_id() {
		return product_review_id;
	}
	public void setProduct_review_id(int product_review_id) {
		this.product_review_id = product_review_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getGrage_id() {
		return grage_id;
	}
	public void setGrage_id(int grage_id) {
		this.grage_id = grage_id;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getGrade_total_count() {
		return grade_total_count;
	}
	public void setGrade_total_count(int grade_total_count) {
		this.grade_total_count = grade_total_count;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
