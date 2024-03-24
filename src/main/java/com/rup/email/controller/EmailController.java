package com.rup.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rup.email.model.Email;
import com.rup.email.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("send/{toMail}")
	public String sendMail(@PathVariable String toMail, @RequestBody Email email) {
		emailService.sendMail(toMail, email);
		return "Mail Sent Successfully.";
	}

}
