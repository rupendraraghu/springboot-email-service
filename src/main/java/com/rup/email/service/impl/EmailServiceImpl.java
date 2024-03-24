package com.rup.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.rup.email.model.Email;
import com.rup.email.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	

	@Override
	public void sendMail(String toMail, Email email) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromMail);
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getText());
		simpleMailMessage.setTo(toMail);
		
		javaMailSender.send(simpleMailMessage);
	}

}
