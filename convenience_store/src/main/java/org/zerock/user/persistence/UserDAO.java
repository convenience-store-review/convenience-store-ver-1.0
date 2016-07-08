package org.zerock.user.persistence;

import org.zerock.domain.User;
import org.zerock.user.dto.LoginDTO;

public interface UserDAO {

	public User login(LoginDTO dto) throws Exception;
	
	public User selectByEmail(String email) throws Exception;
	
	public void create(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(int id) throws Exception;
	
}
