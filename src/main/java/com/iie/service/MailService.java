package com.iie.service;

import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * Created by dev on 7/31/2014.
 */
public interface MailService {
    void sendMessage(MimeMessagePreparator mailMessage);
}
