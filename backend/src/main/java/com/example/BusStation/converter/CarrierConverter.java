package com.example.BusStation.converter;

import com.example.BusStation.model.Carrier;
import com.example.BusStation.web.dto.CarrierDTO;
import org.springframework.stereotype.Component;

@Component
public class CarrierConverter {

    public static CarrierDTO toCarrierDto(Carrier carrier) {
        CarrierDTO dto = new CarrierDTO();
        dto.setId(carrier.getId());
        dto.setName(carrier.getName());
        dto.setAddress(carrier.getAddress());
        dto.setPhoneNumber(carrier.getPhoneNumber());
        dto.setEmail(carrier.getEMail());
        return dto;
    }

}
