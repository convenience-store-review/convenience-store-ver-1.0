package org.review.cvs.user.persistence;

import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.LoginDTO;

public interface UserDAO {

	public User login(LoginDTO dto) throws Exception;
	
	public User selectByEmail(String email) throws Exception;
	
	public User selectByNickname(String nickname) throws Exception;
	
	public void create(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(int id) throws Exception;

	
}
