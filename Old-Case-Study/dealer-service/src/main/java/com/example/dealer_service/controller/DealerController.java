package com.example.dealer_service.controller;

import com.example.dealer_service.entity.Dealer;
import com.example.dealer_service.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerService.createDealer(dealer);
    }

    @GetMapping
    public List<Dealer> getAllDealers() {
        return dealerService.getAllDealers();
    }

    @GetMapping("/{id}")
    public Dealer getDealerById(@PathVariable Long id) {
        return dealerService.getDealerById(id);
    }

    @PutMapping("/{id}")
    public Dealer updateDealer(@PathVariable Long id, @RequestBody Dealer dealer) {
        return dealerService.updateDealer(id, dealer);
    }

    @DeleteMapping("/{id}")
    public void deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
    }
}
