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
	public UserReview read(Integer id) throws Exception {
		
		return dao.read(id);
	}
	
	@Override
	public ProductReview product_info(Integer id) throws Exception {
		
		return dao.product_info(id);
	}
	
	@Override
	public List<UserReview> user_review_list(Integer id) throws Exception {
		return dao.user_review_list(id);
	}
}
