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

    @Override
    public Carrier update(Carrier carrier) {
        if (carrier == null || carrier.getId() == null) {
            throw new IllegalArgumentException("Carrier or Carrier ID must not be null.");
        }
        Carrier existingCarrier = carrierRepository.findById(carrier.getId())
                .orElseThrow(() -> new EntityNotFoundException("Carrier with ID " + carrier.getId() + " not found."));
        return carrierRepository.save(carrier);
    }

    @Override
    public Carrier delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null.");
        }
        Carrier carrier = carrierRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Carrier with ID: " + id + " not found"));
        carrierRepository.delete(carrier);
        return carrier;
    }
}
