package com.example.BusStation.repository;

import com.example.BusStation.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Long> {
}
