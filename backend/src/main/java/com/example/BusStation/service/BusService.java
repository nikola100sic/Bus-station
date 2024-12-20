package com.example.BusStation.service;

import com.example.BusStation.model.Bus;

import java.util.List;

public interface BusService {

    Bus getOne(Long id);

    List<Bus> getAll();

    Bus save(Bus bus);

    Bus update(Bus bus);

    Bus delete(Long id);

}
