package org.review.cvs.collabo.persistence;

import java.util.List;

import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;

public interface CollaboBoardDAO {
	public CollaboReview collaboRead(Integer id) throws Exception;	

	public List<AttachPhoto> attachPhoto(Integer id) throws Exception;
		
	public List<CollaboReview> collaboList() throws Exception;
	
	
	public User create_get_user(Integer id) throws Exception;
	
	public void create_collabo_review(CollaboReview board, Integer grade_id) throws Exception;
	
	public void create_grade(Grade grade) throws Exception;
	
	
	public void update(CollaboReview board) throws Exception;
	
	
	
	public void delete_collabo_review(Integer id) throws Exception;
	
	public void delete_grade(Integer grade_id) throws Exception;
	
	
}
