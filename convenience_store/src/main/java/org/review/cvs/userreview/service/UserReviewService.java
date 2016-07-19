package org.review.cvs.userreview.service;

import java.util.HashMap;
import java.util.List;

import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.ProductReview;
import org.review.cvs.commons.domain.UserReview;

public interface UserReviewService {

	
	public ProductReview product_info(Integer id) throws Exception;
	
	public List<UserReview> user_review_list(Integer id) throws Exception;
	
	public UserReview user_review_read(HashMap<String, Object> map) throws Exception;
	
	public void user_review_modify(UserReview userReview,  Grade grade) throws Exception;
	
	public void user_review_remove(Integer user_review_id, Integer grade_id) throws Exception;
	
	public void user_review_register(UserReview userReview, Grade grade) throws Exception;


}
