package org.zerock.user.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.User;
import org.zerock.user.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	public static final String NAMESPACE = "org.zerock.mapper.UserMapper";
	
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
	
}
