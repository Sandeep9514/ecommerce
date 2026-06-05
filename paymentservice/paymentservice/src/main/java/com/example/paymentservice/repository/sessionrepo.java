package com.example.paymentservice.repository;

import com.example.paymentservice.entity.sessiondetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sessionrepo extends JpaRepository<sessiondetails, String> {
}
