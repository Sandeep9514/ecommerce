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
public class itemDto {
    @Id
    private int itemId;
    private String itemName;
    private int availableUnits;
    private int rating;
    private double price;
}
