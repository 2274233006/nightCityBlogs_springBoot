package com.nightCityBlogs.service;

public interface MailService {
    public void checkMail(String to,String subject,String text);

    void sendTextMailMessage(String to, String subject, String text);
}
