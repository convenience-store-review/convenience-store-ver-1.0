package org.zerock.domain;

import java.util.Date;

public class CollaboReview {
	
	private int id;
	private User user;
	private Grade grade;
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
	
	private String test;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
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
