package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.ProductReview;
import org.zerock.domain.UserReview;
import org.zerock.persistence.UserReivewDAO;

@Service
public class UserReviewServiceImpl implements UserReviewService {
	
	@Inject
	private UserReivewDAO dao;

	
	@Override
	public ProductReview product_info(Integer id) throws Exception {
		
		return dao.product_info(id);
	}
	
	@Override
	public List<UserReview> user_review_list(Integer id) throws Exception {
		return dao.user_review_list(id);
	}
	
	@Override
	public UserReview user_review_read(Integer id) throws Exception {
		return dao.user_review_read(id);
	}
	
	@Override
	public void user_review_modify(UserReview userReview) throws Exception {
		dao.user_review_modify(userReview);
	}
	
	@Override
	public void user_review_remove(UserReview userReview) throws Exception {
		dao.user_review_remove(userReview);
	}
	
	@Override
	public void user_review_register(UserReview userReview) throws Exception {
		dao.user_review_register(userReview);
	}
}
