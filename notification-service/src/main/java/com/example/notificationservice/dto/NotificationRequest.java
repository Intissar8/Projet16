package com.example.notificationservice.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private String toEmail;
    private String toPhone;
    private String message;
}