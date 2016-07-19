package org.review.cvs.user.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.review.cvs.commons.CookieName;
import org.review.cvs.commons.ModelName;
import org.review.cvs.commons.SessionName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("pre handler.......");
		
		HttpSession session = request.getSession();
		if (session.getAttribute(SessionName.LOGIN_USER) != null) {
			logger.info("clear login data before");
			session.removeAttribute(SessionName.LOGIN_USER);
		}
		
		return true;
	}
	
	/**
	 * 특정 메소드의 실행 결과를 HttpSession 객체에 같이 담아야 하는 경우
	 *  1 .컨트롤러에서는 Model 객체에 결과 데이터 저장.
	 *  2. 인터셉터의 postHandler()에서 이를 이용해 HttpSession에 결과 저장.
	 *  장점: 컨트롤러에서 HttpSession 처리 필요가 없게 됨.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("post handler.......");
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object user = modelMap.get(ModelName.LOGIN_USER);
//		logger.info("#### user :" + user);
		if (user != null) {
			logger.info("new login success.\n## new user:{}", user);
			session.setAttribute(SessionName.LOGIN_USER, user);
			
			// Set loginCookie
			if (request.getParameter("useCookie") != null) {
				logger.info("remember me.......");
				Cookie loginCookie = new Cookie(CookieName.LOGIN_COOKIE, session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);	// 7 days
				response.addCookie(loginCookie);
			}
			
			Object dest = session.getAttribute(SessionName.DEST_URI);
			response.sendRedirect(dest != null ? (String)dest : "/user/home");
		}
	}
}
