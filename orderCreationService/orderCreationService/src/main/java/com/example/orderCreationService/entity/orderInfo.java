package com.example.orderCreationService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class orderInfo {

    @Id
    private int userid;
    private int itemId;
    private int orderId;
    private int numofItems;
    private int totalPrice;

    @Override
    public String toString() {
        return "orderInfo{" +
                "userid=" + userid +
                ", itemId=" + itemId +
                ", orderId=" + orderId +
                ", numofItems=" + numofItems +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
