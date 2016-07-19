package org.review.cvs.user.service;

import java.util.Date;

import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.LoginDTO;

public interface UserService {

	public User login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String email, String sessionId, Date next) throws Exception;
	
	public User checkLoginBefore(String value) throws Exception;
	
	public void regist(User user) throws Exception;
	
	public void changePassword(String email, String oldPassword, String newPassword) throws Exception;
}
