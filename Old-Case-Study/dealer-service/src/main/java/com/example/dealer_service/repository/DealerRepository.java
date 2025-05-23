package com.example.dealer_service.repository;

import com.example.dealer_service.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
