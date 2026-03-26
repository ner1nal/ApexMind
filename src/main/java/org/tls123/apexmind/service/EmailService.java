package org.tls123.apexmind.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.tls123.apexmind.model.Lead;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendLeadNotification(Lead lead) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("test@example.com");
        message.setSubject("New Lead");

        message.setText(
                "Name: " + lead.getName() + "\n" +
                        "Email: " + lead.getEmail() + "\n" +
                        "Message: " + lead.getMessage()
        );

        mailSender.send(message);
    }
}
