package org.review.cvs.commons.domain;

import java.util.Date;

import org.review.cvs.user.exception.IdPasswordNotMatchingException;

/**
 * roleId
 * 	0: 가입안한 사람 default
 * 	1: 어드민
 * 	2: 가입한 회원
 * @author kjlee
 *
 */
public class User {

	private int id;
	private String email;
	private String password;
	private String nickname;
	private Date regdate;
	private Date updatedate;
	private String photo;
	private int roleId;		// default 0
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", nickname=" + nickname
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", photo=" + photo + ", roleId=" + roleId
				+ "]";
	}
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		
		this.password = newPassword;
	}
	
}
