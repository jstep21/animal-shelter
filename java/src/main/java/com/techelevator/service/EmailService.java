package com.techelevator.service;

import com.techelevator.model.VolunteerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    private final String HOMEPAGE_BASE_URL = "http://127.0.0.1:5173/";
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
    private final String LINK_TO_CHANGE_PASSWORD = "localhost:5173/update-password";
    private final String LOGIN_INSTRUCTIONS_SUBJECT = "Congratulations! You've Been Approved!";
    private final String LOGIN_INSTRUCTIONS_TEXT = "<p>We have wonderful news!</p>" +
            "<p>Your application has been approved! You can now change your password " +
            "and sign in with the following link: " +
            "<a href='" + LINK_TO_CHANGE_PASSWORD + "'>" + LINK_TO_CHANGE_PASSWORD + "</a></p><p>" +
            "Thank you for joining our passionate team " + "of volunteers, we hope to hear from you soon!</p>";

    private final String APPROVED_SUBJECT = "Volunteer Application Approved!";
    private final String APPROVED_TEXT = "Thanks for your interest in volunteering at " +
            "Sheltered Furry Friends!\n\n" +
            "Congratulations!! Your application to volunteer at the shelter has been approved! " +
            "\n\n" +
            "Next Steps:\n\n";

    private final String DECLINED_SUBJECT = "Volunteer Application Declined";
    private final String DECLINED_TEXT = "Thanks for your interest in volunteering at " +
            "Sheltered Furry Friends.\n\n" +
            "Unfortunately your application to volunteer at the shelter has been declined due to " +
            "not meeting one or more of our acceptance criteria. Please stop by the shelter or " +
            "give us a call for more info." +
            "\n\n";

    private final String LOGIN_INSTRUCTIONS = "- Head to our home page at " + HOMEPAGE_BASE_URL + ".\n" +
            "- Click the Sign In button at the top right\n" +
            "- Sign in with your email address as username and the word \"password\" (all lower case) " +
            "as your password\n" +
            "- Follow the on-screen instructions to change your password\n\n" +
            "You now have access to all of the Volunteer functions on the site. Thanks again " +
            "for your dedication to animal welfare, and look out for an orientation email soon!\n\n";

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Sends 2 emails every time a new volunteer application is submitted
     * (1) Email prompting an admin to approve or reject the volunteer's application
     * (2) Welcome email saying application is under review
     * <p>
     * Plain text email only
     * TODO: Use the MimeMessage class to allow HTML formatted emails and attachments
     * TODO: Error checking
     */
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
        message.setText(DECLINED_TEXT + volunteer.toString());
        mailSender.send(message);
    }

    public void sendEmailToApprovedOrDeclinedVolunteer(VolunteerDto volunteer) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(APP_EMAIL);
        message.setTo(volunteer.getEmail());

        if (volunteer.getApprovalStatus().equals("Approved")) {
            message.setSubject(APPROVED_SUBJECT);
            message.setText(APPROVED_TEXT + LOGIN_INSTRUCTIONS + volunteer.toString());
            System.out.println("Sending approved email to " + volunteer.getEmail());
            mailSender.send(message);
        } else if (volunteer.getApprovalStatus().equals("Declined")) {
            message.setSubject(DECLINED_SUBJECT);
            message.setText(DECLINED_TEXT + volunteer.toString());
            System.out.println("Sending declined email to " + volunteer.getEmail());
            mailSender.send(message);
        } else {
            System.out.println("Error: Unexpected Volunteer approval status received; " +
                    "email not sent. Status: " + volunteer.getApprovalStatus());
        }
    }

    public void sendLoginInstructions(VolunteerDto volunteer) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom(APP_EMAIL);
        helper.setTo(volunteer.getEmail());
        helper.setSubject(LOGIN_INSTRUCTIONS_SUBJECT);
        String htmlContent = LOGIN_INSTRUCTIONS_TEXT;
        helper.setText(htmlContent, true); // Set HTML content
        mailSender.send(message);

        // Was testing both methods to see if i could get a clickable link in the email
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(APP_EMAIL);
//        message.setTo(volunteer.getEmail());
//        message.setSubject(LOGIN_INSTRUCTIONS_SUBJECT);
//        message.setText(LOGIN_INSTRUCTIONS_TEXT);
//        mailSender.send(message);
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

