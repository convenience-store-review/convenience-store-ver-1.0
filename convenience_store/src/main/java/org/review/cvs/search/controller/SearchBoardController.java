package org.review.cvs.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.review.cvs.commons.domain.CollaboReview;
import org.review.cvs.commons.domain.PageMaker;
import org.review.cvs.commons.domain.Product;
import org.review.cvs.commons.domain.SearchCriteria;
import org.review.cvs.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);

	@Inject
	private SearchService service;

	PageMaker pageMaker = new PageMaker();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());
		String st = cri.getSearchType();
		System.out.println("## st:" + st);
		
		if (service.listSearchCount(cri) == 0 || service.collaboListSearchCount(cri) == 0) {
			model.addAttribute("failed", "searchFailed");

			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.collaboListSearchCount(cri));
			model.addAttribute("pageMaker", pageMaker);
		}

		if (st != null && st.equals("l")) {
			model.addAttribute("cList", service.collaListSearchCriteria(cri));
			System.out.println("cri.......:" + cri);
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.collaboListSearchCount(cri));
			model.addAttribute("pageMaker", pageMaker);
			
		} else if (st != null && st.equals("t")) {
			
			model.addAttribute("clist", service.collaListSearchCriteria(cri));
			model.addAttribute("plist", service.listSearchCriteria(cri));
			model.addAttribute("ulist", service.userReviewListSearchCriteria(cri));
			
			
		} else {
			
			model.addAttribute("list", service.listSearchCriteria(cri));

			System.out.println("pageMaker.......:" + service.listCountCriteria(cri));
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.listCountCriteria(cri));
			model.addAttribute("pageMaker", pageMaker);
		}

		// model.addAttribute("cList", service.collaListSearchCriteria(cri));

		// pageMaker.setTotalCount(service.listCountCriteria(cri));

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET() throws Exception {

		logger.info("regist get ...........");
	}

	// @RequestMapping(value = "/list", method = RequestMethod.GET)
	// public void listPage(@ModelAttribute("cri") SearchCriteria cri,
	// Model model) throws Exception {
	//
	// logger.info(cri.toString());
	//
	// model.addAttribute("list", service.listCriteria(cri));
	//
	// PageMaker pageMaker = new PageMaker();
	// pageMaker.setCri(cri);
	//
	// pageMaker.setTotalCount(service.listCountCriteria(cri));
	//
	// model.addAttribute("pageMaker", pageMaker);
	// }
}
