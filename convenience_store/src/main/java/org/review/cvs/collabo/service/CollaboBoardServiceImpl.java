package org.review.cvs.collabo.service;

import java.util.List;

import javax.inject.Inject;

import org.review.cvs.collabo.persistence.CollaboBoardDAO;
import org.review.cvs.commons.domain.AttachPhoto;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
	
	
	@Override
	public List<CollaboReview> collaboList() throws Exception {
		return dao.collaboList();
	}
	
	@Transactional
	@Override
	public void regist(CollaboReview collaboReview,Grade grade) throws Exception {
		dao.create_grade(grade);
		System.out.println(grade.getId());
		dao.create_collabo_review(collaboReview,grade.getId());
	}
	
	@Override
	public User regist_get_user(Integer id) throws Exception {
		return dao.create_get_user(9);
	}
	
	
	
	
	
	@Override
	public void modify(CollaboReview board) throws Exception {
		dao.update(board);
	}
	
	@Transactional
	@Override
	public void remove(Integer id, Integer grade_id) throws Exception {
		dao.delete_collabo_review(id);
		dao.delete_grade(grade_id);
		
	}
	

}
