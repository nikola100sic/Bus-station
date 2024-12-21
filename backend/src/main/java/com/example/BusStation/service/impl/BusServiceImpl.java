package com.example.BusStation.service.impl;

import com.example.BusStation.model.Bus;
import com.example.BusStation.repository.BusRepository;
import com.example.BusStation.service.BusService;
import jakarta.persistence.EntityNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    @Override
    public Bus getOne(Long id) {
        return busRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Bus with ID " + id + " not found."));

    }

    @Override
    public List<Bus> getAll() {
        return busRepository.findAll();
    }

    @Override
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus update(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null.");
        }
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bus with ID " + id + " not found."));
        busRepository.delete(bus);
        return bus;
    }
}
