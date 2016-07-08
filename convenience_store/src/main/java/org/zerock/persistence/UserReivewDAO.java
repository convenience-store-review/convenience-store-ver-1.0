package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.ProductReview;
import org.zerock.domain.UserReview;


public interface UserReivewDAO {
	
	public ProductReview product_info(Integer id) throws Exception;
	
	public List<UserReview> user_review_list(Integer id) throws Exception;
	
	public UserReview user_review_read(Integer id) throws Exception;


}
