package com.example.BusStation.converter;

import com.example.BusStation.model.Line;
import com.example.BusStation.repository.LineRepository;
import com.example.BusStation.web.dto.LineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LineConverter {
    
    public LineDTO toDto(Line line) {
        LineDTO dto = new LineDTO();
        dto.setId(line.getId());
        dto.setDeparture(line.getDeparture());
        dto.setDestination(line.getDestination());
        dto.setDepartureTime(line.getDepartureTime());
        dto.setPrice(line.getPrice());
        dto.setCarriers(line.getCarriers()
                .stream()
                .map(CarrierConverter::toCarrierDto)
                .collect(Collectors.toSet()));
        return dto;
    }
}

