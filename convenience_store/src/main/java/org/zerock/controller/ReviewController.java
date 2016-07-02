package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/review/*")
public class ReviewController {

  private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

  
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void read(@RequestParam("id") int id, Model model) throws Exception {
	  logger.info("show list");
	  System.out.println("!!!!");
  }

}
