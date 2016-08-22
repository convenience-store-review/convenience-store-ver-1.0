package org.review.cvs.collabo.persistence;

import java.util.List;

import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;


public interface CollaboReplyDAO {

	public List<UserReview> list(Integer c_id) throws Exception; //bno였음. collaboReview id여야함.
	
	//user는 정보 get용. 콜라보리뷰의 아이디도 여기서 겟 해서 userReview 등록시 사용해야하나?
	public User create_reply_get_user(Integer id) throws Exception;
	
	public void create_reply_user_review(UserReview userReview, Integer grade_id) throws Exception; 
	
	public Integer create_reply_grade(Grade grade) throws Exception;
	
	//modify get  아래 update가 put
	public UserReview update_get(Integer rno) throws Exception;
	
	public void update_put(Integer rno,UserReview userReview) throws Exception;
	
	
	
	public Integer delete_select_grade(Integer rno) throws Exception;
	
	public void deleteReply(Integer id) throws Exception;  //rno였음. userReview의 id 여야함.
	
	public void deleteReply_Grade(Integer grade_id) throws Exception;
	
	
	
	
	
	public List<UserReview> listPage(
			Integer c_id, Criteria cri) throws Exception;  //bno였
	
	public int count(Integer c_id) throws Exception; //bno였음
	
	
	
	
}
