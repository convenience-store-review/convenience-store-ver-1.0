package org.zerock.domain;

import java.util.Date;

public class CollaboReview {
	
	private int collabo_review_id;
	private int user_id;
	private int grade_id;
	private String title;
	private int total_price;
	private String recipe;
	private String tips;
	private int like_count;
	private int grade_total_count;
	private int view_count;
	private int ispenalty;
	private Date regdate;
	private Date updatedate;
	
	
	public int getCollabo_review_id() {
		return collabo_review_id;
	}
	public void setCollabo_review_id(int collabo_review_id) {
		this.collabo_review_id = collabo_review_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
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
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getIspenalty() {
		return ispenalty;
	}
	public void setIspenalty(int ispenalty) {
		this.ispenalty = ispenalty;
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
