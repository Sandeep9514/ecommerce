package com.example.paymentservice.entity;

import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class sessiondetails {

    private int orderId;
    private int userId;
    @Id
    private String sessionId;
    private String email;
    private String status;

    @Override
    public String toString() {
        return "payment{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
