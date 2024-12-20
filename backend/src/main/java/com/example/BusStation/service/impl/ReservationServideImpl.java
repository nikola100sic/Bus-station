package com.example.BusStation.service.impl;

import com.example.BusStation.model.Reservation;
import com.example.BusStation.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServideImpl implements ReservationService {
    @Override
    public Reservation getOne(Long id) {
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return List.of();
    }

    @Override
    public Reservation save(Reservation line) {
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation delete(Long id) {
        return null;
    }
}
