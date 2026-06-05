package com.example.orderCreationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderCreationServiceApplication {

	public static void main(String[] args) {

        SpringApplication.run(OrderCreationServiceApplication.class, args);

	}

}
