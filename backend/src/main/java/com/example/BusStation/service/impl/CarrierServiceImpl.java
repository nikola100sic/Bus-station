package com.example.BusStation.service.impl;

import com.example.BusStation.exception.carriers.CarrierNotFoundException;
import com.example.BusStation.exception.lines.LineNotFoundException;
import com.example.BusStation.model.Carrier;
import com.example.BusStation.model.Line;
import com.example.BusStation.repository.CarrierRepository;
import com.example.BusStation.repository.LineRepository;
import com.example.BusStation.service.CarrierService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarrierServiceImpl implements CarrierService {

    private final CarrierRepository carrierRepository;
    private final LineRepository lineRepository;


    @Override
    public Carrier getOne(Long id) {
        return carrierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carrier with ID: " + id + " not found"));
    }

    @Override
    public List<Carrier> getAll() {
        return carrierRepository.findAll();
    }

    @Override
    public Carrier save(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null.");
        }
        Carrier carrier = carrierRepository.findById(id).orElseThrow(() ->
                new CarrierNotFoundException(id));

        List<Line> lines = lineRepository.findByCarriersContaining(carrier);
        for (Line line : lines) {
            line.getCarriers().remove(carrier);
            lineRepository.save(line);
        }
        carrierRepository.delete(carrier);
    }
}