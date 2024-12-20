package com.example.BusStation.service.impl;

import com.example.BusStation.model.Carrier;
import com.example.BusStation.service.CarrierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierServiceImpl implements CarrierService {
    @Override
    public Carrier getOne(Long id) {
        return null;
    }

    @Override
    public List<Carrier> getAll() {
        return List.of();
    }

    @Override
    public Carrier save(Carrier carrier) {
        return null;
    }

    @Override
    public Carrier update(Carrier carrier) {
        return null;
    }

    @Override
    public Carrier delete(Long id) {
        return null;
    }
}
