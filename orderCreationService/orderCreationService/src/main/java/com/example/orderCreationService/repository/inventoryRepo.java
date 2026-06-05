package com.example.orderCreationService.repository;

import com.example.orderCreationService.entity.orderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inventoryRepo extends JpaRepository<orderInfo, Integer> {
}
