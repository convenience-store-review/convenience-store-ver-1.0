package org.review.cvs.collabo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.review.cvs.collabo.service.CollaboReplyService;
import org.review.cvs.commons.domain.Criteria;
import org.review.cvs.commons.domain.Grade;
import org.review.cvs.commons.domain.PageMaker;
import org.review.cvs.commons.domain.User;
import org.review.cvs.commons.domain.UserReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collabo/replies")
public class CollaboReplyController {
	
	@Inject
	private CollaboReplyService service;
	
	private static final Logger logger = LoggerFactory.getLogger(CollaboReplyController.class);
	
	//삭제는 c_id/id  delete
	//조회는 /c_id/page get
	//수정은 /mod/rno get   mod/rno put 
	//등록은 /user_id get    /regi post?
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public void registerGET() {
//			
//	}
	
	@RequestMapping(value="/mod/{rno}", method=RequestMethod.GET)
	public ResponseEntity<UserReview> modifyGET(@PathVariable("rno") Integer rno) {
		System.out.println("## modify get............");
		ResponseEntity<UserReview> entity = null;
		try{
			entity = new ResponseEntity<UserReview>(service.modifyReplyGet(rno),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/mod/{rno}", method=RequestMethod.PUT)
	public ResponseEntity<String> modifyPUT(@PathVariable("rno") Integer rno, @RequestBody UserReview userReview) {
		System.out.println("## userreview:" + userReview);
		ResponseEntity<String> entity =null;
		
		try {
			
			//현재 로그인한 사용자가 9 라고 가정.
//			service.addReply_get_user(9);
			Grade grade = new Grade();
			grade.setCalory(userReview.getGrade().getCalory());
			grade.setCost_ratio(userReview.getGrade().getCost_ratio());
			grade.setTaste(userReview.getGrade().getTaste());
			grade.setTotal(userReview.getGrade().getTotal());
			
			service.modifyReplyPut(rno,userReview);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	

	@RequestMapping(value="/{user_id}",method=RequestMethod.GET)
	public ResponseEntity<User> registerGET(@PathVariable("user_id") Integer user_id) {
		System.out.println("## registerGET");
		ResponseEntity<User> entity = null;
		try {
			entity = new ResponseEntity<User>(service.addReply_get_user(user_id), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public ResponseEntity<String> registerPOST(@RequestBody UserReview userReview) {
		System.out.println("## userreview:" + userReview);
		ResponseEntity<String> entity =null;
		
		try {
			
			//현재 로그인한 사용자가 9 라고 가정.
//			service.addReply_get_user(9);
			Grade grade = new Grade();
			grade.setCalory(userReview.getGrade().getCalory());
			grade.setCost_ratio(userReview.getGrade().getCost_ratio());
			grade.setTaste(userReview.getGrade().getTaste());
			grade.setTotal(userReview.getGrade().getTotal());
			
			service.addReply(userReview, grade);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
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
