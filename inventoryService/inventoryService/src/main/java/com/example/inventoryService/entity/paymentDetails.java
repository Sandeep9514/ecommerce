package com.example.inventoryService.entity;

import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class paymentDetails {

    @Id
    private int orderId;
    private int userId;
    private int amount;
    private String currency;

    @Override
    public String toString() {
        return "paymentDetails{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
