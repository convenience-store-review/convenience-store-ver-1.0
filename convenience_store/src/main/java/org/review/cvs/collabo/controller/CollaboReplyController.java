package org.review.cvs.collabo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.review.cvs.collabo.service.CollaboReplyService;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.PageMaker;
import org.review.cvs.commons.domain.UserReview;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collabo/replies")
public class CollaboReplyController {
	@Inject
	private CollaboReplyService service;
	
	// 페이징 처리를 위해서 /게시물 번호/페이지번호 를 패턴으로 처리하고 있습니다.
	@RequestMapping(value="/{c_id}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listPage(
			@PathVariable("c_id") Integer c_id,
			@PathVariable("page") Integer page) {
		
		ResponseEntity<Map<String,Object>> entity = null;
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String,Object> map = new HashMap<String,Object>();
			List<UserReview> list = service.listReplyPage(c_id, cri);
			
			//댓글
			map.put("list", list);
			
			int replyCount = service.count(c_id);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;	
		
	}


}
