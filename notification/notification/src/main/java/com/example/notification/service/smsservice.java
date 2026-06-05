package com.example.notification.service;

@Service
public class smsservice {

        @Value("${twilio.account.sid}")
        private String accountSid;

        @Value("${twilio.auth.token}")
        private String authToken;

        @Value("${twilio.phone.number}")
        private String fromNumber;

        public void sendPaymentSms(PaymentEvent event) {

            Twilio.init(accountSid, authToken);

            String text;

            if ("SUCCESS".equalsIgnoreCase(event.getStatus())) {
                text = "Payment successful for order " + event.getOrderId();
            } else {
                text = "Payment failed for order " + event.getOrderId() + ". Please try again.";
            }

            Message.creator(
                    new PhoneNumber(event.getPhoneNumber()),
                    new PhoneNumber(fromNumber),
                    text
            ).create();
        }
    }

 }
