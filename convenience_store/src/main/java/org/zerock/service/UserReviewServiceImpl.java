package org.zerock.service;

import javax.inject.Inject;

import org.zerock.domain.UserReview;
import org.zerock.persistence.UserReivewDAO;


public class UserReviewServiceImpl implements UserReviewService {
	
	@Inject
	private UserReivewDAO dao;

	public UserReview read(Integer id) throws Exception {
		
		return dao.read(id);
	}
}
