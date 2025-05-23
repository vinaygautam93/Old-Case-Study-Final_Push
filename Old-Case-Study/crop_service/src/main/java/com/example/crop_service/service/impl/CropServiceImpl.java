package com.example.crop_service.service.impl;

import com.example.crop_service.entity.Crop;
import com.example.crop_service.repository.CropRepository;
import com.example.crop_service.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {

    @Autowired
    private CropRepository cropRepository;

    @Override
    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public Crop getCropById(Long id) {
        return cropRepository.findById(id).orElse(null);
    }

    @Override
    public List<Crop> getCropsByFarmerId(Long farmerId) {
        return cropRepository.findByFarmerId(farmerId);
    }

    @Override
    public Crop updateCrop(Long id, Crop crop) {
        Crop existingCrop = cropRepository.findById(id).orElse(null);
        if (existingCrop != null) {
            existingCrop.setName(crop.getName());
            existingCrop.setType(crop.getType());
            existingCrop.setPrice(crop.getPrice());
            existingCrop.setQuantity(crop.getQuantity());
            existingCrop.setFarmerId(crop.getFarmerId());
            return cropRepository.save(existingCrop);
        }
        return null;
    }

    @Override
    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}
