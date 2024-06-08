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
    private final String ADMIN_EMAIL_ADDRESS = "shelteredfurryfriends@gmail.com";
    private final String ADMIN_APPROVAL_PROMPT_EMAIL_SUBJECT =
            "Volunteer Application for Review";
    private final String ADMIN_APPROVAL_PROMPT_EMAIL_TEXT =
            "A new volunteer application has been received " +
                "and requires your approval.\n\n" +
                "Login to the website to review the application.\n\n" +
                "Applicant details below:\n\n";

    private final String WELCOME_APPLICATION_UNDER_REVIEW_EMAIL_SUBJECT =
            "Volunteer Application Received!";
    private final String WELCOME_APPLICATION_UNDER_REVIEW_EMAIL_TEXT =
            "Thanks for your interest in volunteering at Sheltered Furry Friends!\n\n" +
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
     * */
    public void sendEmail(VolunteerDto volunteer) {

       // Email (1) Prompt admin user to approve new volunteer
       // FROM shelteredfurryfriends@gmail.com TO shelteredfurryfriends@gmail.com
       SimpleMailMessage message = new SimpleMailMessage();
       message.setFrom(ADMIN_EMAIL_ADDRESS);
       message.setTo(ADMIN_EMAIL_ADDRESS);
       message.setSubject(ADMIN_APPROVAL_PROMPT_EMAIL_SUBJECT);
       message.setText(ADMIN_APPROVAL_PROMPT_EMAIL_TEXT + volunteer.toString());
       mailSender.send(message);

        // Email (2) Thank volunteer for their interest and say application is under review
        // FROM shelteredfurryfriends@gmail.com TO <volunteer's entered email address>
        message = new SimpleMailMessage();
        message.setFrom(ADMIN_EMAIL_ADDRESS);
        message.setTo(volunteer.getEmail());
        message.setSubject(WELCOME_APPLICATION_UNDER_REVIEW_EMAIL_SUBJECT);
        message.setText(WELCOME_APPLICATION_UNDER_REVIEW_EMAIL_TEXT + volunteer.toString());
        mailSender.send(message);
    }

    // For testing:
    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ADMIN_EMAIL_ADDRESS);
        message.setTo(to);
        message.setSubject("Test");
        message.setText("This is a test of the /send-email endpoint");
        mailSender.send(message);

    }
}
