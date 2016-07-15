package org.review.cvs.userreview.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.ProductReview;
import org.review.cvs.commons.domain.UserReview;



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
	public void user_review_remove(Integer user_review_id) throws Exception {
		session.delete(namespace + ".user_review_delete", user_review_id);
	}
	
	@Override
	public void user_review_register(UserReview userReview, int grade_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userReview", userReview);
		paramMap.put("grade_id", grade_id);
		session.insert(namespace + ".user_review_insert", paramMap);
	}
	
	@Override
	public void user_review_grade_modify(Grade grade) throws Exception {
		
	}
	
	@Override
	public int user_review_grade_register(Grade grade) throws Exception {
		return session.insert(namespace + ".user_review_grade_insert", grade);
	}
	
	@Override
	public void user_review_grade_remove(Integer grade_id) throws Exception {
		session.delete(namespace + ".user_review_grade_delete", grade_id);
	}

}
