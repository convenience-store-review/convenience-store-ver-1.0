package org.zerock.user.service;

import org.zerock.user.domain.User;
import org.zerock.user.dto.LoginDTO;

public interface UserService {

	public User login(LoginDTO dto) throws Exception;
}
