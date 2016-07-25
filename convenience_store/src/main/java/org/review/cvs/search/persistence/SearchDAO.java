package org.review.cvs.search.persistence;

import java.util.List;

import org.review.cvs.commons.domain.BoardVO;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Product;
import org.review.cvs.commons.domain.SearchCriteria;
import org.review.cvs.commons.domain.UserReview;


public interface SearchDAO {


  public int countPaging(Criteria cri) throws Exception;
  
  public int collaboCountPaging(Criteria cri) throws Exception;
  
  //use for dynamic sql
  
  public List<Product> listSearch(SearchCriteria cri) throws Exception;
  
  public List<CollaboReview> collaListSearch(SearchCriteria cri) throws Exception;
  
  public int listSearchCount(SearchCriteria cri)throws Exception;
  
  public int collaboListSearchCount(SearchCriteria cri)throws Exception;
  
  public List<UserReview> userReviewListSearch(SearchCriteria cri) throws Exception;
  
  public int userReviewListSearchCount(SearchCriteria cri)throws Exception;

}
