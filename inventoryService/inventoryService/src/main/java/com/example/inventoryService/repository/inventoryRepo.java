package com.example.inventoryService.repository;

import com.example.inventoryService.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inventoryRepo extends JpaRepository<item, Integer> {

}
