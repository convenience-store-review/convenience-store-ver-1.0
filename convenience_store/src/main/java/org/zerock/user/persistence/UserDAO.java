package org.zerock.user.persistence;

import org.zerock.user.domain.User;
import org.zerock.user.dto.LoginDTO;

public interface UserDAO {

	public User login(LoginDTO dto) throws Exception;
}
