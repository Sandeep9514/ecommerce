package com.example.paymentservice.entity;

import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class paymentData {

    @Id
    private int orderId;
    private int userId;
    private int amount;
    private String currency;

    @Override
    public String toString() {
        return "paymentData{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
