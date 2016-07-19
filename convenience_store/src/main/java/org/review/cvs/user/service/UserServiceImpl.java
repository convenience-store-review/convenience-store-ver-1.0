package org.review.cvs.user.service;

import java.util.Date;

import javax.inject.Inject;

import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.LoginDTO;
import org.review.cvs.user.exception.AlreadyExistingNicknameException;
import org.review.cvs.user.exception.AlreadyExistingUserException;
import org.review.cvs.user.exception.IdPasswordNotMatchingException;
import org.review.cvs.user.exception.UserNotFoundException;
import org.review.cvs.user.persistence.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Transactional
	@Override
	public User login(LoginDTO dto) throws Exception {
		boolean isMember = dao.checkIsMember(dto.getEmail());
		if (!isMember)
			throw new UserNotFoundException();
			
		User user = dao.login(dto);
		if (user == null)
			throw new IdPasswordNotMatchingException();
		
		return user;
	}

	@Transactional
	@Override
	public void regist(User user) throws Exception {
		
		User oldUser = dao.selectByEmail(user.getEmail());
		if (oldUser != null) {
			throw new AlreadyExistingUserException("dup email " + user.getEmail());
		}
		
		oldUser = dao.selectByNickname(user.getNickname());
		if (oldUser != null) {
			throw new AlreadyExistingNicknameException("dup nickname " + user.getNickname());
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

	@Override
	public void keepLogin(String email, String sessionId, Date next) throws Exception {
		dao.keepLogin(email, sessionId, next);
	}

	@Override
	public User checkLoginBefore(String value) throws Exception {
		return dao.checkUserWithSessionKey(value);
	}
	
}
