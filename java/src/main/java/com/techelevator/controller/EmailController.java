package com.techelevator.controller;

import com.techelevator.model.EmailDto;
import com.techelevator.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class EmailController {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/send-email", method = RequestMethod.POST)
    public String sendEmail(@RequestBody EmailDto email) {
        try {
            emailService.sendEmail(email.getTo());
            return "Email sent successfully";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
