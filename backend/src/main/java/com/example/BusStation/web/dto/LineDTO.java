package com.example.BusStation.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class LineDTO {

    private Long id;

    private String departure;

    private String destination;

    private LocalDateTime departureTime;

    private int numberOfSeats;

    private BigDecimal price;

    private Set<CarrierDTO> carriers;
}
