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
import org.zerock.user.dto.ChangePasswordRequest;
import org.zerock.user.dto.LoginDTO;
import org.zerock.user.exception.ConfirmPasswordNotMatchingException;
import org.zerock.user.exception.IdPasswordNotMatchingException;
import org.zerock.user.exception.UserNotFoundException;
import org.zerock.user.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
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
