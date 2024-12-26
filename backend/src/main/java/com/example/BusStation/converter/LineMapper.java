package com.example.BusStation.converter;

import com.example.BusStation.model.Carrier;
import com.example.BusStation.model.Line;
import com.example.BusStation.web.dto.CarrierDTO;
import com.example.BusStation.web.dto.LineDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LineMapper {

    public LineDTO toDto(Line line) {
        LineDTO dto = new LineDTO();
        dto.setId(line.getId());
        dto.setDeparture(line.getDeparture());
        dto.setDestination(line.getDestination());
        dto.setDepartureTime(line.getDepartureTime());
        dto.setPrice(line.getPrice());
        dto.setCarriers(line.getCarriers().stream().map(this::toCarrierDto).collect(Collectors.toSet()));
        return dto;
    }

    private CarrierDTO toCarrierDto(Carrier carrier) {
        CarrierDTO dto = new CarrierDTO();
        dto.setId(carrier.getId());
        dto.setName(carrier.getName());
        dto.setAddress(carrier.getAddress());
        dto.setPhoneNumber(carrier.getPhoneNumber());
        dto.setEmail(carrier.getEMail());
        return dto;
    }
}

