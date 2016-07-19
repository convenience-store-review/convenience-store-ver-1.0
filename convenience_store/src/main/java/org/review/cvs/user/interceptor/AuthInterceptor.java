package org.review.cvs.user.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.review.cvs.commons.CookieName;
import org.review.cvs.commons.SessionName;
import org.review.cvs.commons.domain.User;
import org.review.cvs.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Inject
	private UserService userService;
	
	/**
	 * 특정 경로에 접근하는 경우, 현재 사용자가 로그인한 상태의 사용자인지를 체크하는 역할을 처리한다.
	 * - 특정 경로 접근 여부: user-context.xml 참조
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("pre handler.......");
		
		HttpSession session = request.getSession();
//		logger.info("## session ## loginUser:" + session.getAttribute(SessionName.LOGIN_USER));
		if (session.getAttribute(SessionName.LOGIN_USER) == null) {
			logger.info("current user is not logined");
			
			saveDest(request);
			
			Cookie loginCookie = WebUtils.getCookie(request, CookieName.LOGIN_COOKIE);
			if (loginCookie != null) {
//				logger.info("#### 1111");
//				logger.info("#### loginCookie:" + loginCookie.getValue());
				User user = userService.checkLoginBefore(loginCookie.getValue());
				logger.info("USER:{}", user);
				
				if (user != null) {
					logger.info("## AuthInter ## set login session");
					session.setAttribute(SessionName.LOGIN_USER, user);
					return true;
				}
			}
//			logger.info("#### 2222");
			response.sendRedirect("/user/login");
			return false;
		}
//		logger.info("#### 3333");
		return true;
	}

	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if (req.getMethod().equals("GET")) {
			logger.info("dest:{}", (uri + query));
			req.getSession().setAttribute(SessionName.DEST_URI, uri + query);
		}
	}
	
}
