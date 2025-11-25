package com.example.notificationservice.service;

import com.example.notificationservice.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;

    public void sendNotification(NotificationRequest req) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(req.getToEmail());
        mail.setSubject("Confirmation Rendez-Vous");
        mail.setText(req.getMessage());
        mailSender.send(mail);

        System.out.println("Email envoyé à : " + req.getToEmail());
    }
}