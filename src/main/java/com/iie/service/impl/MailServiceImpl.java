package com.iie.service.impl;

import com.iie.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * Created by dev on 7/31/2014.
 */
@Service
public class MailServiceImpl implements MailService {


    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendMessage(MimeMessagePreparator mailMessage) {
        mailSender.send(mailMessage);
    }
}
