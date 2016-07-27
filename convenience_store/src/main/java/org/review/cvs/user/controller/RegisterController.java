package org.review.cvs.user.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.review.cvs.commons.domain.User;
import org.review.cvs.user.dto.RegisterRequest;
import org.review.cvs.user.exception.AlreadyExistingNicknameException;
import org.review.cvs.user.exception.AlreadyExistingUserException;
import org.review.cvs.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register/*")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value = "/step1")
	public String step1GET() {
		logger.info("step1 get..........");
		return "register/step1";
	}
	
	@RequestMapping(value = "/step2", method=RequestMethod.GET)
	public String step2GET() {
		logger.info("step2 get..........");
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value = "/step2", method=RequestMethod.POST)
	public String step2POST(
			@RequestParam(value="agree", defaultValue="false") Boolean agreeVal,
			Model model) {
		logger.info("step2 post..........agree:{}", agreeVal == true ? "true":"false");
		
		if (! agreeVal)
			return "register/step1";
		
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
	@RequestMapping(value = "/step3", method=RequestMethod.GET)
	public String step3GET() {
		logger.info("step3 get..........");
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value = "/step3", method=RequestMethod.POST)
	public String step3POST(@Valid RegisterRequest request, Errors errors) throws Exception {
		logger.info("step3 post..........");
		
		if (errors.hasErrors()) {
			System.out.println("## error:" + errors.getAllErrors().toString());
			return "register/step2";
		}
		
		if (! request.isPasswordEqualToConfirmPassword()) {
			System.out.println("\n암호와 암호 확인이 일치하지 않습니다!\n");
			errors.rejectValue("password", "confirm.nomatch");
//			throw new ConfirmPasswordNotMatchingException();
			return "register/step2";
		}
		
		try {
			User user = new User();
			user.setEmail(request.getEmail());
			user.setPassword(request.getPassword());
			user.setNickname(request.getNickname());
			
			service.regist(user);
			System.out.println("\n등록했습니다.\n");
			
			return "/register/step3";
		} catch (AlreadyExistingUserException e) {
			System.out.println("\n이미 존재하는 이메일입니다.\n");
			errors.rejectValue("email", "duplicate");
			return "/register/step2";
		} catch (AlreadyExistingNicknameException e) {
			System.out.println("\n이미 존재하는 닉네임입니다.\n");
			errors.rejectValue("nickname", "duplicate");
			return "/register/step2";
		}
	}
	
}
