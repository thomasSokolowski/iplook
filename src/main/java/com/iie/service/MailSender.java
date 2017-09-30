package com.iie.service;

import com.iie.dto.EmailDto;

/**
 * Created by dev on 7/31/2014.
 */
public interface MailSender {
    void sendEmail(EmailDto emailDto);
}
