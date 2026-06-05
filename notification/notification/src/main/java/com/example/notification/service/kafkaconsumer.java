package com.example.notification.service;

@KafkaListener(
        topics = {"payment-success", "payment-failed"},
        groupId = "notification-service-group"
)
public class kafkaconsumer {


        emailService.sendPaymentEmail(event);
        smsService.sendPaymentSms(event);



}
