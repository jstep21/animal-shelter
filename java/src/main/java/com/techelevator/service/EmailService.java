package com.techelevator.service;

import com.techelevator.model.VolunteerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    private final String APP_EMAIL = "shelteredfurryfriends@gmail.com";
    private final String ADMIN_EMAIL = "shelteredfurrymanager@gmail.com";
    private final String APPROVE_PROMPT_SUBJECT = "Volunteer Application for Review";
    private final String APPROVE_PROMPT_TEXT = "A new volunteer application has been received " +
            "and requires your approval.\n\n" +
            "Login to the website to review the application.\n\n" +
            "Applicant details below:\n\n";
    private final String UNDER_REVIEW_SUBJECT = "Volunteer Application Received!";
    private final String UNDER_REVIEW_TEXT = "Thanks for your interest in volunteering at " +
            "Sheltered Furry Friends!\n\n" +
            "Your application is under review for approval, and we'll " +
            "let you know soon!\n\n" +
            "Applicant Details Below\n\n";

    /**
     * Sends 2 emails every time a new volunteer application is submitted
     * (1) Email prompting an admin to approve or reject the volunteer's application
     * (2) Welcome email saying application is under review
     *
     * Plain text email only
     * TODO: Use the MimeMessage class to allow HTML formatted emails and attachments
     * TODO: Error checking
     * */
    public void sendEmailsWhenAddingNewVolunteer(VolunteerDto volunteer) {

        // Send email (1) Prompt admin user to approve new volunteer.
        //  FROM app email <shelteredfurryfriends@gmail.com>
        //  TO admin email <shelteredfurrymanager@gmail.com>
       SimpleMailMessage message = new SimpleMailMessage();
       message.setFrom(APP_EMAIL);
       message.setTo(ADMIN_EMAIL);
       message.setSubject(APPROVE_PROMPT_SUBJECT);
       message.setText(APPROVE_PROMPT_TEXT + volunteer.toString());
       mailSender.send(message);

        // Send email (2) Thank volunteer for their interest and say application is under review.
        //  FROM app email <shelteredfurryfriends@gmail.com>
        //  TO volunteer's entered email address <get from Volunteer DTO>
        message = new SimpleMailMessage();
        message.setFrom(APP_EMAIL);
        message.setTo(volunteer.getEmail());
        message.setSubject(UNDER_REVIEW_SUBJECT);
        message.setText(UNDER_REVIEW_TEXT + volunteer.toString());
        mailSender.send(message);
    }

    // For testing:
    public void sendEmailsWhenAddingNewVolunteer(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(APP_EMAIL);
        message.setTo(to);
        message.setSubject("Test");
        message.setText("This is a test of the /send-email endpoint");
        mailSender.send(message);

    }
}
