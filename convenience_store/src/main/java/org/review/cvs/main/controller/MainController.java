package org.review.cvs.main.controller;

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
@RequestMapping("/*")
public class MainController {

private static final Logger logger = LoggerFactory.getLogger(MainController.class);
  
  @Inject
  private CollaboBoardService service;
  
  //상세페이지 보기
  @RequestMapping(value="", method=RequestMethod.GET)
  public String dd() throws Exception{
	  return "index";
	  
  }
  
}
