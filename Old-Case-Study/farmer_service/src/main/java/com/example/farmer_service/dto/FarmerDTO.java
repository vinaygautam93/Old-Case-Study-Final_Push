package com.example.farmer_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmerDTO {
    private Long id;
    private String name;
    private String phone;
    private String location;
}
