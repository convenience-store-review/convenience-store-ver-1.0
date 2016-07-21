package org.review.cvs.collabo.persistence;

import java.util.List;

import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.UserReview;


public interface CollaboReplyDAO {

	public List<UserReview> list(Integer c_id) throws Exception; //bno였음. collaboReview id여야함.
	
	public void create(UserReview vo) throws Exception;
	
	public void update(UserReview vo) throws Exception;
	
	public void delete(Integer id) throws Exception;  //rno였음. userReview의 id 여야함.
	
	public List<UserReview> listPage(
			Integer c_id, Criteria cri) throws Exception;  //bno였
	
	public int count(Integer c_id) throws Exception; //bno였음
	
	
	
	
}
