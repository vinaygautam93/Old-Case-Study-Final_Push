package com.example.dealer_service.service;

import com.example.dealer_service.entity.Dealer;

import java.util.List;

public interface DealerService {
    Dealer createDealer(Dealer dealer);
    List<Dealer> getAllDealers();
    Dealer getDealerById(Long id);
    Dealer updateDealer(Long id, Dealer dealer);
    void deleteDealer(Long id);
}
