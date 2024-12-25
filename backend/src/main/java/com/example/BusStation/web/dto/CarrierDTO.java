package com.example.BusStation.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarrierDTO {

    private Long id;

    private String name;

    private String address;

    private String phoneNumber;
    
    private String email;
}
