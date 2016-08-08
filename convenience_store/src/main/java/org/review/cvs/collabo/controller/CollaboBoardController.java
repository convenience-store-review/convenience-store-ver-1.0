package org.review.cvs.collabo.controller;

import javax.inject.Inject;

import org.review.cvs.collabo.service.CollaboBoardService;
import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.Grade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/collabo/*")
public class CollaboBoardController {

  private static final Logger logger = LoggerFactory.getLogger(CollaboBoardController.class);
  
  @Inject
  private CollaboBoardService service;
  
  //상세페이지 보기
  @RequestMapping(value="/read", method=RequestMethod.GET)
  public void read(@RequestParam("id") int id, Model model) throws Exception{
	  logger.info("read get...............");
	  model.addAttribute(service.collaboRead(id));
	  logger.info("photo..................");
	  model.addAttribute("photolist",service.attachPhoto(id));
  }
  
  //전체리스트 보기
  @RequestMapping(value="/listall", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list................");
		model.addAttribute("listall",service.collaboList());
	}
  //등록하기
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(Model model) throws Exception {
	
	  logger.info("register get ...........");
	  model.addAttribute("user",service.regist_get_user(9));
	}
	
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	 public String registPOST(CollaboReview board, Grade grade, Model model) throws Exception {
	
	 logger.info("regist post ...........");
	 logger.info(board.toString());
	
	 service.regist(board,grade);
	
	 model.addAttribute("result", "success");
	
	 //return "/board/success";
	 return "redirect:/collabo/listall";
	 }
  
	 //RedirectAttributes 객체는 리다이렉트 시점에 한번만 사용되는 데이터를 전송할 수 있는 
	 //addFlashAttribute()라는 기능을 지원합니다. 숨겨진 데이터의 형대로 전달한다.
	 
	 @RequestMapping(value = "/remove", method=RequestMethod.POST)
	 public String remove(@RequestParam("id") int id, @RequestParam("grade_id") int grade_id,
			 RedirectAttributes rttr) throws Exception {
		 
		 service.remove(id,grade_id);
		 
		 rttr.addFlashAttribute("msg", "SUCCESS");
		 
		 return "redirect:/collabo/listall";
	 }
	 
	 @RequestMapping(value="/modify", method=RequestMethod.GET)
	 public void modifyGET(int id, Model model) throws Exception {
		 model.addAttribute(service.collaboRead(id));
	 }
	 
	 
	 
	 @RequestMapping(value="/modify", method=RequestMethod.POST)
	 public String modifyPOST(CollaboReview board,
			 RedirectAttributes rttr) throws Exception {
		 
		 logger.info("mod post...................");
		 
		 service.modify(board);
		 rttr.addFlashAttribute("msg","SUCCESS");
		 
		 return "redirect:/collabo/listall";
	 }
  
  
  
  
  
  
  //전체리스트 보기
//  @RequestMapping(value="/listPage", method=RequestMethod.GET)
//	public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
//		logger.info(cri.toString());
//		
//		model.addAttribute("list",service.listCriteria(cri));
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//
//		//테스트용도
//		//pageMaker.setTotalCount(131);
//		
//		pageMaker.setTotalCount(service.listCountCriteria(cri));
//		
//		model.addAttribute("pageMaker",pageMaker);
//	}
//  
  
  
  
  

//  @RequestMapping(value = "/register", method = RequestMethod.GET)
//  public void registerGET(BoardVO board, Model model) throws Exception {
//
//    logger.info("register get ...........");
//  }

  // @RequestMapping(value = "/register", method = RequestMethod.POST)
  // public String registPOST(BoardVO board, Model model) throws Exception {
  //
  // logger.info("regist post ...........");
  // logger.info(board.toString());
  //
  // service.regist(board);
  //
  // model.addAttribute("result", "success");
  //
  // //return "/board/success";
  // return "redirect:/board/listAll";
  // }

//  @RequestMapping(value = "/register", method = RequestMethod.POST)
//  public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
//
//    logger.info("regist post ...........");
//    logger.info(board.toString());
//
//    service.regist(board);
//
//    rttr.addFlashAttribute("msg", "success");
//    return "redirect:/board/listAll";
//  }
//
//  @RequestMapping(value = "/listAll", method = RequestMethod.GET)
//  public void listAll(Model model) throws Exception {
//
//    logger.info("show all list......................");
//    model.addAttribute("list", service.listAll());
//  }
//
//  @RequestMapping(value = "/read", method = RequestMethod.GET)
//  public void read(@RequestParam("bno") int bno, Model model) throws Exception {
//
//    model.addAttribute(service.read(bno));
//  }
//
//  @RequestMapping(value = "/remove", method = RequestMethod.POST)
//  public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
//
//    service.remove(bno);
//
//    rttr.addFlashAttribute("msg", "SUCCESS");
//
//    return "redirect:/board/listAll";
//  }
//
//  @RequestMapping(value = "/modify", method = RequestMethod.GET)
//  public void modifyGET(int bno, Model model) throws Exception {
//
//    model.addAttribute(service.read(bno));
//  }
//
//  @RequestMapping(value = "/modify", method = RequestMethod.POST)
//  public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
//
//    logger.info("mod post............");
//
//    service.modify(board);
//    rttr.addFlashAttribute("msg", "SUCCESS");
//
//    return "redirect:/board/listAll";
//  }
//  
//  @RequestMapping(value = "/listCri", method = RequestMethod.GET)
//  public void listAll(Criteria cri, Model model) throws Exception {
//
//    logger.info("show list Page with Criteria......................");
//
//    model.addAttribute("list", service.listCriteria(cri));
//  }
//  
//  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
//  public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//
//    logger.info(cri.toString());
//
//    model.addAttribute("list", service.listCriteria(cri));
//    PageMaker pageMaker = new PageMaker();
//    pageMaker.setCri(cri);
//    // pageMaker.setTotalCount(131);
//
//    pageMaker.setTotalCount(service.listCountCriteria(cri));
//
//    model.addAttribute("pageMaker", pageMaker);
//  }
// 
//  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
//  public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//
//    model.addAttribute(service.read(bno));
//  }
//
//  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
//  public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
//
//    service.remove(bno);
//
//    rttr.addAttribute("page", cri.getPage());
//    rttr.addAttribute("perPageNum", cri.getPerPageNum());
//    rttr.addFlashAttribute("msg", "SUCCESS");
//
//    return "redirect:/board/listPage";
//  }
//
//  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
//  public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)
//      throws Exception {
//
//    model.addAttribute(service.read(bno));
//  }
}
