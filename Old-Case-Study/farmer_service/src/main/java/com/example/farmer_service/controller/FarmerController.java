package com.example.farmer_service.controller;

import com.example.farmer_service.dto.FarmerDTO;
import com.example.farmer_service.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping
    public FarmerDTO createFarmer(@RequestBody FarmerDTO farmerDTO) {
        return farmerService.createFarmer(farmerDTO);
    }

    @GetMapping("/{id}")
    public FarmerDTO getFarmerById(@PathVariable Long id) {
        return farmerService.getFarmerById(id);
    }

    @GetMapping
    public List<FarmerDTO> getAllFarmers() {
        return farmerService.getAllFarmers();
    }
}
