package org.review.cvs.user.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.review.cvs.commons.CookieName;
import org.review.cvs.commons.ModelName;
import org.review.cvs.commons.SessionName;
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
import org.springframework.web.util.WebUtils;

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
//			logger.info("## error:{}", errors.getAllErrors().toString());
			return "/user/login";
		}
		
		try {
			User user = service.login(dto);
			if (user == null) {
//				logger.info("## user is null");
				return "/user/login";
			}
			
			model.addAttribute(ModelName.LOGIN_USER, user);
			
			if (dto.isUseCookie()) {
				int amount = 60 * 60 * 24 * 7; // 7 days
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
//				logger.info("## CONT ## limit:{}", sessionLimit);
				service.keepLogin(user.getEmail(), session.getId(), sessionLimit);
			}
			
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "/user/login";
		} catch (UserNotFoundException e) {
			errors.reject("emailNotFound");
			return "/user/login";
		}
		
		return "/user/loginPost";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception {
		logger.info("logout get.........");
		
		// 로그인 세션 제거
		Object obj = session.getAttribute(SessionName.LOGIN_USER);
		logger.info("## logout ## obj:{}", obj);
		if (obj != null) {
			User user = (User)obj;
			
			session.removeAttribute(SessionName.LOGIN_USER);
			session.invalidate();
			
			// 로그인 쿠키 제거
			Cookie loginCookie = WebUtils.getCookie(request, CookieName.LOGIN_COOKIE);
			logger.info("## logout ## loginCookie:{}", String.valueOf(loginCookie));
			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(user.getEmail(), session.getId(), new Date());
			}
		}
		return "/user/logout";
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
