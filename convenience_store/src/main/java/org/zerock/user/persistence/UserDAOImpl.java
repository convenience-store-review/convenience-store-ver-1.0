package org.zerock.user.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.user.domain.User;
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

}
