package org.zerock.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.User;
import org.zerock.user.dto.LoginDTO;
import org.zerock.user.exception.AlreadyExistingUserException;
import org.zerock.user.exception.UserNotFoundException;
import org.zerock.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public User login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Transactional
	@Override
	public void regist(User user) throws Exception {
		
		User oldUser = dao.selectByEmail(user.getEmail());
		if (oldUser != null) {
			throw new AlreadyExistingUserException("dup email " + user.getEmail());
		}
		
		dao.create(user);
	}

	@Transactional
	@Override
	public void changePassword(String email, String oldPassword, String newPassword) throws Exception {

		User user = dao.selectByEmail(email);
		if (user == null)
			throw new UserNotFoundException();
		
		user.changePassword(oldPassword, newPassword);
		
		dao.update(user);
	}

}
