package org.review.cvs.user.service;

import org.review.cvs.commons.domain.User;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendMailServiceTest implements SendMailService {
	
    private MailSender mailSender;
    
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
 
    @Override
    public void sendEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("[공지] 회원 가입 안내");
        message.setText("회원 가입을 축하합니다.");
        message.setFrom("kyung_ho@naver.com");
        message.setTo(user.getEmail());
        try {
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    } // sendEmail

}
