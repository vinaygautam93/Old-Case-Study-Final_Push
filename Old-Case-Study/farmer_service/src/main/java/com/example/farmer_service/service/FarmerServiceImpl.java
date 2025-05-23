package com.example.farmer_service.service;

import com.example.farmer_service.dto.FarmerDTO;
import com.example.farmer_service.entity.Farmer;
import com.example.farmer_service.exception.CustomException;
import com.example.farmer_service.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public FarmerDTO createFarmer(FarmerDTO dto) {
        Farmer farmer = Farmer.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .location(dto.getLocation())
                .build();

        Farmer saved = farmerRepository.save(farmer);

        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public FarmerDTO getFarmerById(Long id) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Farmer not found with id: " + id));

        return FarmerDTO.builder()
                .id(farmer.getId())
                .name(farmer.getName())
                .phone(farmer.getPhone())
                .location(farmer.getLocation())
                .build();
    }

    @Override
    public List<FarmerDTO> getAllFarmers() {
        return farmerRepository.findAll().stream()
                .map(farmer -> FarmerDTO.builder()
                        .id(farmer.getId())
                        .name(farmer.getName())
                        .phone(farmer.getPhone())
                        .location(farmer.getLocation())
                        .build())
                .collect(Collectors.toList());
    }
}
