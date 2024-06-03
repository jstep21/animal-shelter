package com.techelevator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;


    // TODO: Change to accept parameters passed from Email DTO, not hard coded text
    // TODO: Use the MimeMessage class to allow HTML formatted emails and attachments
    // TODO: Note volunteer application should actually go to an admin user not back to the
    //  sender like it's doing now -- perhaps we connect the db user table to a new table with this email address??
    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shelteredfurryfriends@gmail.com");
        message.setTo(to);
        message.setSubject("Volunteer Application for Review");
        message.setText("Volunteer Application for Review\n\n" +
                "A new animal shelter volunteer application has been received " +
                "and requires your review for approval.\n\n" +
                "Application details below:\n" +
                "[PLACEHOLDER]");
        mailSender.send(message);

    }
}
