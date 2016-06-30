package org.zerock.domain;

import java.util.Date;

public class UserReview {
	
	private int user_review_id;
	private int user_id;
	private int grade_id;
	private int product_review_id;
	private int collabo_review_id;
	private String content1;
	private String content2;
	private String content3;
	private int help_count;
	private int ispenalty;
	private Date regdate;
	private Date updatedate;
	
	public int getUser_review_id() {
		return user_review_id;
	}
	public void setUser_review_id(int user_review_id) {
		this.user_review_id = user_review_id;
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
