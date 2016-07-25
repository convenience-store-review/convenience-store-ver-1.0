package org.review.cvs.collabo.service;

import java.util.List;

import javax.inject.Inject;

import org.review.cvs.collabo.persistence.CollaboReplyDAO;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;
import org.springframework.stereotype.Service;

@Service
public class CollaboReplyServiceImpl implements CollaboReplyService {

	
	@Inject
	private CollaboReplyDAO dao;
	
	
	@Override
	public void addReply(UserReview userReview,Grade grade) throws Exception {
		dao.create_reply_grade(grade);
		dao.create_reply_user_review(userReview, grade.getId());
	}
	@Override
	public User addReply_get_user(Integer id) throws Exception {
		return dao.create_reply_get_user(id);
	}
	
	
	
	@Override
	public List<UserReview> listReply (Integer c_id) throws Exception {
		return dao.list(c_id);
	}
	
	public void modifyReply(UserReview vo) throws Exception {
		dao.update(vo);
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
