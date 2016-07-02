package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.UserReview;
import org.zerock.domain.User;
import org.zerock.domain.Grade;
import org.zerock.domain.ProductReview;
import org.zerock.domain.CollaboReview;

@Repository
public class UserReviewImpl implements UserReivewDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace
	="org.zerock.mapper.UserReviewMapper";
	
	@Override
	public UserReview read(Integer id)throws Exception {
		return session.selectOne(namespace+".read", id);
	}

}
