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
@Setter
@Getter
public class item {
    @Id
    private int itemId;
    private String itemName;
    private int availableUnits;
    private int rating;
    private double price;
}
