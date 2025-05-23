package com.example.dealer_service.service.impl;

import com.example.dealer_service.entity.Dealer;
import com.example.dealer_service.repository.DealerRepository;
import com.example.dealer_service.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerServiceImpl implements DealerService {

    private final DealerRepository dealerRepository;

    @Override
    public Dealer createDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @Override
    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    @Override
    public Dealer getDealerById(Long id) {
        return dealerRepository.findById(id).orElseThrow();
    }

    @Override
    public Dealer updateDealer(Long id, Dealer updatedDealer) {
        Dealer dealer = dealerRepository.findById(id).orElseThrow();
        dealer.setName(updatedDealer.getName());
        dealer.setEmail(updatedDealer.getEmail());
        dealer.setPhone(updatedDealer.getPhone());
        dealer.setLocation(updatedDealer.getLocation());
        return dealerRepository.save(dealer);
    }

    @Override
    public void deleteDealer(Long id) {
        dealerRepository.deleteById(id);
    }
}
