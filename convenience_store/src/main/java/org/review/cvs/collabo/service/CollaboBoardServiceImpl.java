package org.review.cvs.collabo.service;

import java.util.List;

import javax.inject.Inject;

import org.review.cvs.collabo.persistence.CollaboBoardDAO;
import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.BoardVO;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.SearchCriteria;
import org.springframework.stereotype.Service;


@Service
public class CollaboBoardServiceImpl implements CollaboBoardService {
	
	@Inject
	private CollaboBoardDAO dao;
	
	@Override
	public CollaboReview collaboRead(Integer id) throws Exception {
		return dao.collaboRead(id);
	}
	
	@Override
	public List<AttachPhoto> attachPhoto(Integer id) throws Exception {
		return dao.attachPhoto(id);
	}
	
	
//	@Override
//	public void regist(BoardVO board) throws Exception {
//		dao.create(board);
//	}
//	
//	@Override
//	public BoardVO read(Integer bno) throws Exception {
//		return dao.read(bno);
//	}
//	
//	@Override
//	public void modify(BoardVO board) throws Exception {
//		dao.update(board);
//	}
//	
//	@Override
//	public void remove(Integer bno) throws Exception{
//		dao.delete(bno);
//	}
//	
//	@Override
//	public List<BoardVO> listAll() throws Exception {
//		return dao.listAll();
//	}
//	
//	@Override
//	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
//		return dao.listCriteria(cri);
//	}
//	
//	@Override
//	public int listCountCriteria(Criteria cri) throws Exception {
//		return dao.countPaging(cri);
//	}
//	
//	@Override
//	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
//		return dao.listSearch(cri);
//	}
//	
//	@Override
//	public int listSearchCount(SearchCriteria cri) throws Exception {
//		return dao.listSearchCount(cri);
//	}

}
