package org.review.cvs.collabo.persistence;

import java.util.List;

import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.CollaboReview;

public interface CollaboBoardDAO {
	public CollaboReview collaboRead(Integer id) throws Exception;	

	public List<AttachPhoto> attachPhoto(Integer id) throws Exception;
		
	public List<CollaboReview> collaboList() throws Exception;
	
	public void create(CollaboReview board) throws Exception;
}
