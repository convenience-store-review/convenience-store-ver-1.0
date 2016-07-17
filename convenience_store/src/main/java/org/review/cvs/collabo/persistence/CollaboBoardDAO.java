package org.review.cvs.collabo.persistence;

import java.util.List;

import org.review.cvs.commons.domain.BoardVO;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.SearchCriteria;

public interface CollaboBoardDAO {
	public CollaboReview collaboRead(Integer id) throws Exception;	

	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	//페이징 처리와 관련된 기능 추가 
	public List<BoardVO> listPage(int page) throws Exception;
	
	//페이징처리에서 criteria적용
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	//페이징에 필요한 totalCount를 반환할 수 있게 처리하기 위해서 추
	public int countPaging(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	
	
}
