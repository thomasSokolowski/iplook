package com.iie.service.impl;

import com.iie.dto.EmailDto;
import com.iie.service.MailSender;
import com.iie.service.MailService;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//

/**
 * Created by dev on 7/31/2014.
 */
@Component
public class MailSenderImpl implements MailSender {
    @Autowired
    private MailService mailService;

    @Autowired
    private VelocityEngine velocityEngine;

    private static final String ENCODING="UTF-8";

    @Override
    public void sendEmail(final EmailDto emailDto) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                message.setTo(emailDto.getTo());
                message.setFrom(new InternetAddress(emailDto.getFrom()));
                message.setSubject(emailDto.getSubject());

                String body = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, emailDto.getTemplate(), ENCODING, emailDto.getVelocityStuffing());
                message.setText(body, true);

                if (!StringUtils.isBlank(emailDto.getAttachmentPath())) {
                    FileSystemResource file = new FileSystemResource(emailDto.getAttachmentPath());
                    message.addAttachment(emailDto.getAttachmentName(), file);
                }
            }
        };
      mailService.sendMessage(preparator);
    }

    private SimpleMailMessage convertEmailDtoToSimpleMailMessage(EmailDto emailDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailDto.getFrom());
        simpleMailMessage.setTo(emailDto.getTo());
        simpleMailMessage.setText(emailDto.getText());
        simpleMailMessage.setSubject(emailDto.getSubject());
        if (StringUtils.isNotEmpty(emailDto.getBcc())) {
            simpleMailMessage.setBcc(emailDto.getBcc());
        }
        if (StringUtils.isNotEmpty(emailDto.getCc())) {
            simpleMailMessage.setCc(emailDto.getCc());
        }

        return simpleMailMessage;
    }
}
