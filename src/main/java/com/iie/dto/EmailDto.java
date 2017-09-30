package com.iie.dto;

import java.io.File;
import java.util.Map;

/**
 * Created by dev on 7/31/2014.
 */
public class EmailDto {
    private String subject;
    private String to;
    private String text;
    private String from;
    private String bcc;
    private String cc;
    private File file;
    private String attachmentPath;
    private String attachmentName;
    private String template;
    private Map<String,Object> velocityStuffing;

    public EmailDto(String subject, String to, String text, String from, String bcc, String cc, File file, String attachmentPath, String attachmentName, String template, Map<String, Object> velocityStuffing) {
        this.subject = subject;
        this.to = to;
        this.text = text;
        this.from = from;
        this.bcc = bcc;
        this.cc = cc;
        this.file = file;
        this.attachmentPath = attachmentPath;
        this.attachmentName = attachmentName;
        this.template = template;
        this.velocityStuffing = velocityStuffing;
    }

    public EmailDto() {
    }

    public Map<String, Object> getVelocityStuffing() {
        return velocityStuffing;
    }

    public void setVelocityStuffing(Map<String, Object> velocityStuffing) {
        this.velocityStuffing = velocityStuffing;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "subject='" + subject + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
