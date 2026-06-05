package com.example.notification.service;

@Service
@RequiredArgsConstructor
public class emailservice {

        private final JavaMailSender mailSender;

        public void sendPaymentEmail(PaymentEvent event) {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(event.getEmail());
            message.setSubject("Payment " + event.getStatus());

            if ("SUCCESS".equalsIgnoreCase(event.getStatus())) {
                message.setText(
                        "Hi,\n\nYour payment was successful for order: "
                                + event.getOrderId()
                                + "\n\nThank you."
                );
            } else {
                message.setText(
                        "Hi,\n\nYour payment failed for order: "
                                + event.getOrderId()
                                + "\n\nPlease try again."
                );
            }

            mailSender.send(message);
        }
    }

}
