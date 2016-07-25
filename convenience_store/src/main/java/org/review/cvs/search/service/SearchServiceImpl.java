package org.review.cvs.search.service;

import java.util.List;

import javax.inject.Inject;

import org.review.cvs.commons.domain.BoardVO;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Product;
import org.review.cvs.commons.domain.SearchCriteria;
import org.review.cvs.commons.domain.UserReview;
import org.review.cvs.search.persistence.SearchDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SearchServiceImpl implements SearchService {

  @Inject
  private SearchDAO dao;
  
  
  @Override
  public int listCountCriteria(Criteria cri) throws Exception {

    return dao.countPaging(cri);
  }
  
  @Override
  public List<Product> listSearchCriteria(SearchCriteria cri) throws Exception {

    return dao.listSearch(cri);
  }

  @Override
  public int listSearchCount(SearchCriteria cri) throws Exception {

    return dao.listSearchCount(cri);
  }

@Override
public int listCollaboCountCriteria(Criteria cri) throws Exception {
	
	return dao.collaboCountPaging(cri);
}

@Override
public List<CollaboReview> collaListSearchCriteria(SearchCriteria cri) throws Exception {
	
	return dao.collaListSearch(cri);
}

@Override
public int collaboListSearchCount(SearchCriteria cri) throws Exception {
	
	return dao.collaboListSearchCount(cri);
}

@Override
public List<UserReview> userReviewListSearchCriteria(SearchCriteria cri) throws Exception {
	
	return dao.userReviewListSearch(cri);
}

@Override
public int userReviewListSearchCount(SearchCriteria cri) throws Exception {
	
	return dao.userReviewListSearchCount(cri);
}



}
