package com.example.BusStation.service.impl;

import com.example.BusStation.model.Bus;
import com.example.BusStation.repository.BusRepository;
import com.example.BusStation.service.BusService;
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
        return busRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Bus> getAll() {
        return List.of();
    }

    @Override
    public Bus save(Bus bus) {
        return null;
    }

    @Override
    public Bus update(Bus bus) {
        return null;
    }

    @Override
    public Bus delete(Long id) {
        return null;
    }
}
