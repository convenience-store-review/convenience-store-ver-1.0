package org.cvs.domain;

import java.util.Date;

public class UserReview {
	
	private int id;
	private User user;
	private Grade grade;
	private ProductReview productReview;
	private CollaboReview collaboReview;
	private String content1;
	private String content2;
	private String content3;
	private int help_count;
	private int ispenalty;
	private Date regdate;
	private Date updatedate;
	
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
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	public int getHelp_count() {
		return help_count;
	}
	public void setHelp_count(int help_count) {
		this.help_count = help_count;
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
