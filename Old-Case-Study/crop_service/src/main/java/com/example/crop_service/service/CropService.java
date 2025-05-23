package com.example.crop_service.service;

import com.example.crop_service.entity.Crop;

import java.util.List;

public interface CropService {
    Crop saveCrop(Crop crop);
    List<Crop> getAllCrops();
    Crop getCropById(Long id);
    List<Crop> getCropsByFarmerId(Long farmerId);
    Crop updateCrop(Long id, Crop crop);
    void deleteCrop(Long id);
}
