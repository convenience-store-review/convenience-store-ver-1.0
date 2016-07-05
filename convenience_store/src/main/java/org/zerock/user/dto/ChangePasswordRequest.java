package org.zerock.user.dto;

public class ChangePasswordRequest {

	private String email;
	private String oldPassword;
	private String newPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	@Override
	public String toString() {
		return "RegisterRequest ["
				+ "email=" + email + ", "
				+ "password=" + oldPassword + ", "
				+ "confirmPassword=" + newPassword + "]";
	}
	
	public boolean isPasswordEqualToConfirmPassword() {
		return oldPassword.equals(newPassword);
	}
	
}
