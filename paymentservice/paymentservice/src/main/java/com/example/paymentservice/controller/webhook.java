package com.example.paymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.stripe.model.Event;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripe")
public class webhook {

    @PostMapping("/webhook")
    public ResponseEntity<String> stripewebhook(
            @RequestBody String payload) {

        Event event =
                Event.GSON.fromJson(
                        payload,
                        Event.class
                );

        if("checkout.session.completed"
                .equals(event.getType())) {

            System.out.println("PAYMENT SUCCESS");
        }

        if("payment_intent.payment_failed"
                .equals(event.getType())) {

            System.out.println("PAYMENT FAILED");
        }

        return ResponseEntity.ok("OK");
    }
}
