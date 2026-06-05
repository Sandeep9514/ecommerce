package com.example.paymentservice.consumer;

import com.example.paymentservice.entity.paymentData;
import com.example.paymentservice.entity.stripeResponse;
import com.example.paymentservice.service.stripeService;
import org.springframework.kafka.annotation.KafkaListener;

public class kafkaConsumer {

    private stripeService service;

    public kafkaConsumer(stripeService service) {
        this.service = service;
    }

    @KafkaListener(
            topics = "inventory_created",
            groupId = "payment-group"
    )
    public void consume(paymentData event){
        //need event.getName() ---> Have to pass product name (String)
        //need event.getAMount() ---> in Long
        //need event.getQuantity() ---> in Long
        stripeResponse strres = service.payment(event);
    }
}
