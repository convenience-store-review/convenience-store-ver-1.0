package org.review.cvs.userreview.persistence;

import java.util.HashMap;
import java.util.List;

import org.review.cvs.commons.domain.UserReview;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.ProductReview;




public interface UserReivewDAO {
	
	public ProductReview product_info(Integer id) throws Exception;
	
	public List<UserReview> user_review_list(Integer id) throws Exception;
	
	public UserReview user_review_read(HashMap<String, Object> map) throws Exception;
	
	public void user_review_modify(UserReview userReview) throws Exception;
	
	public void user_review_remove(Integer user_review_id) throws Exception;
	
	public void user_review_register(UserReview userReview, int grade_id) throws Exception;
	
	public void user_review_grade_modify(Grade grade) throws Exception;
	
	public int user_review_grade_register(Grade grade) throws Exception;
	
	public void user_review_grade_remove(Integer grade_id) throws Exception;


}
