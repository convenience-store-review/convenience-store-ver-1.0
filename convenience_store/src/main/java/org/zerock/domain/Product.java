package org.zerock.domain;

import java.util.Date;

public class Product {
	
	private int product_id;
	private String name;
	private int price;
	private String photo;
	private boolean ispb;
	private String pbname;
	private String company;
	private Date regdate;
	private int product_category_id;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isIspb() {
		return ispb;
	}
	public void setIspb(boolean ispb) {
		this.ispb = ispb;
	}
	public String getPbname() {
		return pbname;
	}
	public void setPbname(String pbname) {
		this.pbname = pbname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getProduct_category_id() {
		return product_category_id;
	}
	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}
	
	
	
}
