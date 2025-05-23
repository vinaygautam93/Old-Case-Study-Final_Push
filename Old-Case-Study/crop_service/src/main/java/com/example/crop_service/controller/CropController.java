package com.example.crop_service.controller;

import com.example.crop_service.entity.Crop;
import com.example.crop_service.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
        return ResponseEntity.ok(cropService.saveCrop(crop));
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable Long id) {
        return ResponseEntity.ok(cropService.getCropById(id));
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<Crop>> getCropsByFarmer(@PathVariable Long farmerId) {
        return ResponseEntity.ok(cropService.getCropsByFarmerId(farmerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crop> updateCrop(@PathVariable Long id, @RequestBody Crop crop) {
        return ResponseEntity.ok(cropService.updateCrop(id, crop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return ResponseEntity.ok("Crop deleted successfully.");
    }
}
