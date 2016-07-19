package org.review.cvs.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.review.cvs.commons.ModelName;
import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.ChangePasswordRequest;
import org.review.cvs.user.dto.LoginDTO;
import org.review.cvs.user.exception.ConfirmPasswordNotMatchingException;
import org.review.cvs.user.exception.IdPasswordNotMatchingException;
import org.review.cvs.user.exception.UserNotFoundException;
import org.review.cvs.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("loginDTO") LoginDTO dto) {
		logger.info("login get..........");
	}
	
	@RequestMapping(value = "/loginPost", method=RequestMethod.GET)
	public String loginPostGET(@ModelAttribute("loginDTO") LoginDTO dto) {
		logger.info("loginPost get..........");
		return "/user/login";
	}
	
	@RequestMapping(value = "/loginPost", method=RequestMethod.POST)
	public String loginPOST(@Valid LoginDTO dto, Errors errors, 
			HttpSession session, Model model) throws Exception {
		logger.info("login post..........\ndto:{}", dto);
		
		if (errors.hasErrors()) {
			System.out.println("## error:" + errors.getAllErrors().toString());
			return "/user/login";
		}
		
		try {
			User user = service.login(dto);
			model.addAttribute(ModelName.LOGIN_USER, user);
			
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "/user/login";
		}
		
		return "/user/loginPost";
	}
	
	@RequestMapping(value = "/changePassword", method=RequestMethod.GET)
	public void changePasswordGET(ChangePasswordRequest request) throws Exception {
		logger.info("changePassword get..........");
		
		if (! request.isPasswordEqualToConfirmPassword())
			throw new ConfirmPasswordNotMatchingException();
		
		try {
			service.changePassword(
					request.getEmail(),
					request.getOldPassword(),
					request.getNewPassword());
			
			System.out.println("\n암호를 변경했습니다.\n");
		} catch (UserNotFoundException e) {
			System.out.println("\n존재하지 않는 이메일입니다.\n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("\n이메일과 암호가 일치하지 않습니다.\n");
		}
	}
}
