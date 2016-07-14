package org.review.cvs.userreview.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.review.cvs.commons.domain.UserReview;
import org.review.cvs.commons.domain.ProductReview;


@Repository
public class UserReviewImpl implements UserReivewDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace
	="org.review.cvs.mapper.UserReviewMapper";
	
	
	@Override
	public ProductReview product_info(Integer id) throws Exception {
		  return session.selectOne(namespace + ".product_info", id);
	}
	
	@Override
	public List<UserReview> user_review_list(Integer id) throws Exception {
		return session.selectList(namespace + ".user_review_list", id);
	}
	
	@Override
	public UserReview user_review_read(HashMap<String, Object> map) throws Exception {
		return session.selectOne(namespace +".user_review_read", map);
	}
	
	@Override
	public void user_review_modify(UserReview userReview) throws Exception {
		session.update(namespace + ".user_review_update", userReview);
		session.update(namespace +".user_review_grade_update", userReview);
	}
	
	@Override
	public void user_review_remove(UserReview userReview) throws Exception {
		session.delete(namespace + ".user_review_delete", userReview);
	}
	
	@Override
	public void user_review_register(UserReview userReview) throws Exception {
		session.insert(namespace + ".user_review_grade_insert", userReview);
		session.insert(namespace + ".user_review_insert", userReview);
	}

}
