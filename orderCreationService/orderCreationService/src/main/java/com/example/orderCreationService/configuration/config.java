package com.example.orderCreationService.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class config {

    @Bean
    public NewTopic kafkaConfig(){

        return TopicBuilder
                .name("Order_created")
                .build();
    }

}
