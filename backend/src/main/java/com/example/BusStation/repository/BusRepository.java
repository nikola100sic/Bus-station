package com.example.BusStation.repository;

import com.example.BusStation.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
