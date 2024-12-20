package com.example.BusStation.service;

import com.example.BusStation.model.Carrier;

import java.util.List;

public interface CarrierService {

    Carrier getOne(Long id);

    List<Carrier> getAll();

    Carrier save(Carrier carrier);

    Carrier update(Carrier carrier);

    Carrier delete(Long id);
}
