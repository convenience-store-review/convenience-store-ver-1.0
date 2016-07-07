package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.service.UserReviewService;


@Controller
@RequestMapping("/review/*")
public class ReviewController {

  private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

  @Inject
  private UserReviewService service;
  
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void read(@RequestParam("id") int id, Model model) throws Exception {
	  logger.info("show list");
	  model.addAttribute(service.product_info(id));
	  model.addAttribute("list", service.user_review_list(id));
  }

}
