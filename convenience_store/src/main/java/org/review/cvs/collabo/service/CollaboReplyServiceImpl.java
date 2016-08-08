package org.review.cvs.collabo.service;

import java.util.List;

import javax.inject.Inject;

import org.review.cvs.collabo.persistence.CollaboReplyDAO;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CollaboReplyServiceImpl implements CollaboReplyService {

	
	@Inject
	private CollaboReplyDAO dao;
	
	@Transactional
	@Override
	public void addReply(UserReview userReview,Grade grade) throws Exception {
		int id = dao.create_reply_grade(grade);
		System.out.println("[dao]" + grade.getId());
		dao.create_reply_user_review(userReview, id);
	}
	@Override
	public User addReply_get_user(Integer id) throws Exception {
		return dao.create_reply_get_user(id);
	}
	
	
	
	@Override
	public List<UserReview> listReply (Integer c_id) throws Exception {
		return dao.list(c_id);
	}
	

	public UserReview modifyReplyGet(Integer rno) throws Exception {
		return dao.update_get(rno);
	}
	
	public void modifyReplyPut(Integer rno,UserReview userReview) throws Exception {
		dao.update_put(rno,userReview);
	}
	
	
	
	public void removeReply(Integer id) throws Exception {
		dao.delete(id);
	}
	
	public List<UserReview> listReplyPage(Integer c_id, Criteria cri) throws Exception {
		return dao.listPage(c_id, cri);
	}
	
	public int count(Integer c_id) throws Exception {
		return dao.count(c_id);
	}
	
}
