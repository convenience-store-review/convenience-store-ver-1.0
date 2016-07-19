package org.review.cvs.user.persistence;

import java.util.Date;

import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.LoginDTO;

public interface UserDAO {

	public User login(LoginDTO dto) throws Exception;
	
	public boolean checkIsMember(String email) throws Exception;
	
	public void keepLogin(String email, String sessionId, Date next) throws Exception;
	
	public User checkUserWithSessionKey(String value) throws Exception;
	
	public User selectByEmail(String email) throws Exception;
	
	public User selectByNickname(String nickname) throws Exception;
	
	public void create(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(int id) throws Exception;

	
}
