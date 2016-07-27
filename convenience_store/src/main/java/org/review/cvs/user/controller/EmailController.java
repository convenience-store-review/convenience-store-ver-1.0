package org.review.cvs.user.controller;

import javax.inject.Inject;

import org.review.cvs.user.domain.Email;
import org.review.cvs.user.domain.EmailSender;
import org.review.cvs.user.service.UserService;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/email/*")
public class EmailController {

//	@Inject
//	private UserService userService;
	
	@Inject
	private EmailSender emailSender;
	
	@RequestMapping("/send")
	public String sendEmail() throws Exception {
		
        Email email = new Email();
        
        /*
			aaa.com 이라는 사이트에서 인증 시스템을 만든다 치면
			1. aaa,com/member/join 에서 이메일 주소를 입력받겠죠. (이메일 인증전 상태)
			2. aaa.com/member/join 가입신청을 받으면 토큰키를 생성해서 DB에 저장해놓습니다.
			3. smtp를 이용해서 회원이메일로 메일을 발송합니다. 이때 DB에 저장해놓은 토큰값과 인증하는 URL 경로를 같이 보냅니다. 아래와 같은 식이 되겠죠.
			  ex). aaa.com/member/active?token=abcdefg1234 or aaa.com/member/active/abcdefg1234
			4. URL 요청을 받았으니 DB에 저장했던 값을 체크를합니다. 위에 토큰값이 입력될경우 계정을 활성화 합니다.
			5. 이후에 로그인 시키고(세션 or 쿠키 생성) 메인페이지던 사용자페이지던 이동을 합니다.
         * 
         * 1. 인증 코드는 10자리 해시코드로 만든다. 
         *    ex) /confirm?code=GMCTeHwNkd&email=user@company.com
         *    ex) /active?token=abcdefg1234 or aaa.com/member/active/abcdefg1234
         * 2. 인증 코드의 유효시간은 생성시부터 24시간 안에 인증되어야한다.
         *  - 24시간 안에 인증이 안되면 해당 메일은 특별한 요청이 없는한 Blocker로 등록된다.
         * 3. 이렇게 만들어진 코드는 링크로 생성되어 메일로 보내져야한다. 
				## 인증 해시 테이블 모델
				사용자email 	- 인증코드10자리 	- 생성날짜 
				1 			- sdfs0-23jfs 	- 2014.2.2T11:11:11
         */
        
        
        String receiver = "ranianopen@email.com"; //받을사람의 이메일
        String subject = "[삼각김밥] 회원가입 이메일 인증을 진행합니다.";
        String content =
        		"안녕하세요, 고객님"
        		+ "[삼각김밥] 회원가입을 위해 이메일 인증을 진행합니다."
        		+ "회원가입을 완료하시려면 아래의 인증링크를 클릭하세요.";
        
        try {
        	email.setReceiver(receiver);	// 받을 사람 이메일
        	email.setSubject(subject);
        	email.setContent(content);
            emailSender.SendEmail(email);
        } catch (MailException e) {
            e.printStackTrace();
        }
         
        return "/user/emailSuccess";
	}
	
	/*
	@RequestMapping("/sendpw.do")
	public ModelAndView sendEmailAction(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Exception {
		ModelAndView mav;
		String id = (String) paramMap.get("id");
		String e_mail = (String) paramMap.get("email");
		String pw = mainService.getPw(paramMap);
		System.out.println(pw);
		if (pw != null) {
			email.setContent("비밀번호는 " + pw + " 입니다.");
			email.setReceiver(e_mail);
			email.setSubject(id + "님 비밀번호 찾기 메일입니다.");
			emailSender.SendEmail(email);
			mav = new ModelAndView("redirect:/login.do");
			return mav;
		} else {
			mav = new ModelAndView("redirect:/logout.do");
			return mav;
		}
	}
	*/

}
