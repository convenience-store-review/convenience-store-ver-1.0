package org.review.cvs.userreview.service;

import java.util.HashMap;
import java.util.List;

import org.review.cvs.commons.domain.ProductReview;
import org.review.cvs.commons.domain.UserReview;

public interface UserReviewService {

	
	public ProductReview product_info(Integer id) throws Exception;
	
	public List<UserReview> user_review_list(Integer id) throws Exception;
	
	public UserReview user_review_read(HashMap<String, Object> map) throws Exception;
	
	public void user_review_modify(UserReview userReview) throws Exception;
	
	public void user_review_remove(UserReview userReview) throws Exception;
	
	public void user_review_register(UserReview userReview) throws Exception;

}
