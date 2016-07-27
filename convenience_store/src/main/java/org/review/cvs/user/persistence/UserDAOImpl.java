package org.review.cvs.user.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	public static final String NAMESPACE = "org.review.cvs.mapper.UserMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public User login(LoginDTO dto) throws Exception {
		return session.selectOne(NAMESPACE + ".login", dto);
	}

	@Override
	public User selectByEmail(String email) throws Exception {
		return session.selectOne(NAMESPACE + ".selectByEmail", email);
	}

	@Override
	public void create(User user) throws Exception {
		session.insert(NAMESPACE + ".create", user);
	}

	@Override
	public void update(User user) throws Exception {
		session.update(NAMESPACE + ".update", user);
	}

	@Override
	public void delete(int id) throws Exception {
		session.delete(NAMESPACE + ".delete", id);
	}

	@Override
	public User selectByNickname(String nickname) throws Exception {
		return session.selectOne(NAMESPACE + ".selectByNickname", nickname);
	}

	@Override
	public void keepLogin(String email, String sessionId, Date next) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
//		System.out.println("## DAO ## paramMap:" + paramMap.toString());
				
		session.update(NAMESPACE + ".keepLogin", paramMap);
	}

	@Override
	public User checkUserWithSessionKey(String value) throws Exception {
		return session.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
	}

	@Override
	public boolean checkIsMember(String email) throws Exception {
		User user = selectByEmail(email);
		if (user == null)
			return false;
		if (user.getEmail() == null)
			return false;
		if (user.getEmail().isEmpty())
			return false;
		
		return true;
	}
	
}
