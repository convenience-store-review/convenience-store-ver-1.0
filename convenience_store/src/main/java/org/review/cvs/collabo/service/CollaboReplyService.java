package org.review.cvs.collabo.service;

import java.util.List;

import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;



public interface CollaboReplyService {

	//create
	public void addReply(UserReview userReview,Grade grade) throws Exception;
	
	public User addReply_get_user(Integer id) throws Exception;
	
	
	//read
	public List<UserReview> listReply (Integer c_id) throws Exception; //bno
	
	//실 사용하는 read
	public List<UserReview> listReplyPage(Integer c_id, Criteria cri) throws Exception;  //bno
	
	public int count(Integer c_id) throws Exception;  //bno
	
	
	//수정용
	public UserReview modifyReplyGet(Integer rno) throws Exception;
	
	public void modifyReplyPut(Integer rno,UserReview userReview) throws Exception;
	
	
	
	
	
	public void removeReply(Integer id) throws Exception; //rno
	
	
	

	
}
