package com.iie.utils.messages;

import com.iie.dto.EmailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/9/2014.
 */
@Component
@Scope("prototype")
public class WarningEmail {

    @Value("${mail.subject}")
    private String subject;

    @Value("${mail.to}")
    private String to;

    @Value("${mail.from}")
    private String from;

    private final static String WARNING_EMAIL_TEMPLATE = "/templates/warningEmail.vm";

    public EmailDto generateMessage(String cause) {
        EmailDto email= new EmailDto();
        email.setFrom(from);
        email.setTo(to);
        email.setSubject(subject);
        email.setTemplate(WARNING_EMAIL_TEMPLATE);
        Map model = new HashMap<>();
        model.put("service", cause);
        email.setVelocityStuffing(model);
        return email;
    }
}
