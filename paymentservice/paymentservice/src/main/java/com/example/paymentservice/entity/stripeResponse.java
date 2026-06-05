package com.example.paymentservice.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class stripeResponse {

    private String message;
    private String status;
    private String sessionId;
    private String sessionUrl;
}
