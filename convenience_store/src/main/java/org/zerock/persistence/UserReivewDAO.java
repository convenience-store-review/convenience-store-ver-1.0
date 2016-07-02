package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.UserReview;


public interface UserReivewDAO {
	
	public UserReview read(Integer id)throws Exception;


}
