package com.example.BusStation.service.impl;

import com.example.BusStation.model.Carrier;
import com.example.BusStation.repository.CarrierRepository;
import com.example.BusStation.service.CarrierService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarrierServiceImpl implements CarrierService {

    private final CarrierRepository carrierRepository;

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
}
