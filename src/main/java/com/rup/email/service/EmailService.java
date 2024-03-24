package com.rup.email.service;

import com.rup.email.model.Email;

public interface EmailService {
	
	void sendMail(String toMail, Email email);

}
