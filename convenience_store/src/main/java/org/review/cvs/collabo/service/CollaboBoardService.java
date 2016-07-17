package org.review.cvs.collabo.service;

import java.util.List;

import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.CollaboReview;


public interface CollaboBoardService {
	
	public CollaboReview collaboRead(Integer id) throws Exception;
	
	public List<AttachPhoto> attachPhoto(Integer id) throws Exception;
	
//	public void regist(BoardVO board) throws Exception;
//	
//	public BoardVO read(Integer bno) throws Exception;
//	
//	public void modify(BoardVO board) throws Exception;
//	
//	public void remove(Integer bno) throws Exception;
//	
//	public List<BoardVO> listAll() throws Exception;
//	
//	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
//	
//	//전체 게시물 숫자 계산 P280
//	public int listCountCriteria(Criteria cri) throws Exception;
//	
//	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
//	
//	public int listSearchCount(SearchCriteria cri) throws Exception;

}
