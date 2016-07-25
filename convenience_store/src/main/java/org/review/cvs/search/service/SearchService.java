package org.review.cvs.search.service;

import java.util.List;

import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Product;
import org.review.cvs.commons.domain.SearchCriteria;
import org.review.cvs.commons.domain.UserReview;

public interface SearchService {

	public int listCountCriteria(Criteria cri) throws Exception;

	public int listCollaboCountCriteria(Criteria cri) throws Exception;

	public List<Product> listSearchCriteria(SearchCriteria cri) throws Exception;

	public List<CollaboReview> collaListSearchCriteria(SearchCriteria cri) throws Exception;

	public List<UserReview> userReviewListSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public int collaboListSearchCount(SearchCriteria cri) throws Exception;

	public int userReviewListSearchCount(SearchCriteria cri) throws Exception;

}
