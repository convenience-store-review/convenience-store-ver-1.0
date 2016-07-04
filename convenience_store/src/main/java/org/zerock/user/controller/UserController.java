package org.zerock.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.common.ModelName;
import org.zerock.user.domain.User;
import org.zerock.user.dto.LoginDTO;
import org.zerock.user.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public void homeET() {
		logger.info("home get..........");
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		logger.info("login get..........");
	}
	
	@RequestMapping(value = "/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("login post..........\ndto:{}", dto);
		
		User user = service.login(dto);
		if (user == null) {
			System.out.println("## login failed!!");
			return;
		}
		
		model.addAttribute(ModelName.LOGIN_USER, user);
	}
	
}
