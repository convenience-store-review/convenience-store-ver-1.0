package org.review.cvs.collabo.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;
import org.springframework.stereotype.Repository;

@Repository
public class CollaboReplyDAOImpl implements CollaboReplyDAO {
	
	

	@Inject
	private SqlSession session;
	
	
	private static String namespace="org.review.cvs.mapper.CollaboReplyMapper";
	
	@Override
	public List<UserReview> list(Integer c_id) throws Exception {
		return session.selectList(namespace + ".list",c_id);
	}
	
	//user는 정보 get용. 콜라보리뷰의 아이디도 여기서 겟 해서 userReview 등록시 사용해야하나?
	@Override
	public User create_reply_get_user(Integer id) throws Exception {
		return session.selectOne(namespace + ".create_reply_get_user",id);
	}
		
	@Override
	public void create_reply_user_review(UserReview userReview, Integer grade_id) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userReview" , userReview);
		paramMap.put("grade_id", grade_id);
		session.insert(namespace + ".create_reply_user_review" , paramMap);
	}
		
	@Override
	public void create_reply_grade(Grade grade) throws Exception {
		session.insert(namespace + ".create_reply_grade",grade);
	}
	
	
	@Override
	public void update(UserReview vo) throws Exception  {
		session.update(namespace + ".update", vo);
	}
	
	@Override
	public void delete(Integer id) throws Exception {
		session.delete(namespace + ".delete", id);
	}
	
	@Override
	public List<UserReview> listPage(
			Integer c_id, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("c_id", c_id);
		paramMap.put("cri", cri);
		
		return session.selectList(namespace + ".listPage", paramMap);
	}
	
	@Override
	public int count(Integer c_id) throws Exception {
		return session.selectOne(namespace+".count",c_id);
	}
	
	


}
