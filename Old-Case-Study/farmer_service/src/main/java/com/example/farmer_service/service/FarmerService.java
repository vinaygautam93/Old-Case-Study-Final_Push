package com.example.farmer_service.service;

import com.example.farmer_service.dto.FarmerDTO;
import java.util.List;

public interface FarmerService {
    FarmerDTO createFarmer(FarmerDTO farmerDTO);
    FarmerDTO getFarmerById(Long id);
    List<FarmerDTO> getAllFarmers();
}
