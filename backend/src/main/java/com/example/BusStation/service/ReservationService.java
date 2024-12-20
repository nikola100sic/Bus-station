package com.example.BusStation.service;

import com.example.BusStation.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation getOne(Long id);

    List<Reservation> getAll();

    Reservation save(Reservation line);

    Reservation update(Reservation reservation);

    Reservation delete(Long id);
}
