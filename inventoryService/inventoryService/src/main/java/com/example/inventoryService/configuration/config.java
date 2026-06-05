package com.example.inventoryService.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class config {

    @Bean
    public NewTopic inventorycreation(){

        return TopicBuilder
                .name("inventory_created")
                .build();
    }

    @Bean
    public NewTopic inventoryfailure(){

        return TopicBuilder
                .name("inventory_failed")
                .build();
    }
}


