package org.zerock.user.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	/**
	 * Object handler: 현재 실행하려는 메소드 자체를 의미
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre handler.......");
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean:" + method.getBean());
		System.out.println("Method:" + methodObj);
		
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
		System.out.println("post handler.......");
		
		Object result = modelAndView.getModel().get("result");
		if (result != null) {
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/user/doA");
		}
	}
}
