package org.review.cvs.collabo.service;

import java.util.List;

import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;



public interface CollaboReplyService {

	public void addReply(UserReview userReview,Grade grade) throws Exception;
	
	public User addReply_get_user(Integer id) throws Exception;
	
	
	
	public List<UserReview> listReply (Integer c_id) throws Exception; //bno
	
	
	public void modifyReply(UserReview vo) throws Exception;
	
	public void removeReply(Integer id) throws Exception; //rno
	
	
	
	public List<UserReview> listReplyPage(Integer c_id, Criteria cri) throws Exception;  //bno
	
	public int count(Integer c_id) throws Exception;  //bno
	
}