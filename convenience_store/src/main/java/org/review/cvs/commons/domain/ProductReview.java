package org.review.cvs.commons.domain;

import java.util.Date;

public class ProductReview {
	
	private int id;
	private Product product;
	private Grade grade;
	private int like_count;
	private int grade_total_count;
	private Date regdate;
	private Date updatedate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
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
