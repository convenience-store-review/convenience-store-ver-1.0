package org.review.cvs.collabo.service;

import java.util.List;

import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;



public interface CollaboBoardService {
	
	public CollaboReview collaboRead(Integer id) throws Exception;
	
	public List<AttachPhoto> attachPhoto(Integer id) throws Exception;
	
	public List<CollaboReview> collaboList() throws Exception;
	
	public void regist(CollaboReview board, Grade grade) throws Exception;
	
	public User regist_get_user(Integer id) throws Exception;
		
	public void modify(CollaboReview board) throws Exception;
	
	public void remove(Integer id, Integer grade_id) throws Exception;
	
//	//전체 게시물 숫자 계산 P280
//	public int listCountCriteria(Criteria cri) throws Exception;
//	
//	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
//	
//	public int listSearchCount(SearchCriteria cri) throws Exception;

}
