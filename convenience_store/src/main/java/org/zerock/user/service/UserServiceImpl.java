package org.zerock.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.user.domain.User;
import org.zerock.user.dto.LoginDTO;
import org.zerock.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public User login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

}
