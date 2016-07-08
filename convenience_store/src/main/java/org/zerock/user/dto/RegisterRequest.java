package org.zerock.user.dto;

public class RegisterRequest {

	private String email;
	private String password;
	private String confirmPassword;
	private String nickname;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", nickname=" + nickname + "]";
	}
	
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
}