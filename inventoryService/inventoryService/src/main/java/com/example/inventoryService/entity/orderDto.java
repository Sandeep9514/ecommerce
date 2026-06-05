package com.example.inventoryService.entity;

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
public class orderDto {
    @Id
    private int userId;
    private int ordderId;
    private int itemId;
    private int numofItems;
    private int totalPrice;
}
