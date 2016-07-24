package org.review.cvs.collabo.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.springframework.stereotype.Repository;

//여기에서 만드는 mapper와 연결시켜 쿼리를 실행.
// .create  .read 이런것들이 mapper파일에서 id  
@Repository
public class CollaboBoardDAOImpl implements CollaboBoardDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace="org.review.cvs.mapper.CollaboMapper";
	
	@Override
	public CollaboReview collaboRead(Integer id) throws Exception {
		return session.selectOne(namespace+".collaboread",id);
	}
	
	@Override
	public List<AttachPhoto> attachPhoto(Integer id) throws Exception {
		return session.selectList(namespace+".collabophoto",id);
	}
	
	@Override
	public List<CollaboReview> collaboList() throws Exception {
		return session.selectList(namespace + ".collabolist");
	}
	
	//글 등록하기  
	
	@Override
	public User create_get_user(Integer id) throws Exception {
		return session.selectOne(namespace + ".create_get_user",id);
	}
	
	@Override
	public void create_collabo_review(CollaboReview collaboReview, Integer grade_id) throws Exception{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("collaboReview" , collaboReview);
		paramMap.put("grade_id", grade_id);
		session.insert(namespace + ".create_collabo_review" , paramMap);
	}
	
	@Override
	public void create_grade(Grade grade) throws Exception {
		session.insert(namespace + ".create_grade" , grade);
	}
	
	
	
	
	
	@Override
	public void update(CollaboReview board) throws Exception {
		session.update(namespace + ".update", board);
	}
	
	
	
	@Override
	public void delete_collabo_review(Integer id) throws Exception {
		session.delete(namespace + ".delete_collabo_review",id);
	}
	
	@Override
	public void delete_grade(Integer grade_id) throws Exception {
		session.delete(namespace + ".delete_grade", grade_id);
	}
		
}
