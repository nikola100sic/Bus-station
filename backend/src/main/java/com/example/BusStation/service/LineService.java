package com.example.BusStation.service;

import com.example.BusStation.model.Line;
import com.example.BusStation.web.dto.LineDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface LineService {

    LineDTO getOne(Long id);

    List<LineDTO> getAll();

    List<LineDTO> search(LocalDateTime date, String destination, String departure, Integer maxPrice, Integer minPrice, int pageNo);

    LineDTO save(Line line);

    LineDTO update(Line line, Long id);

    void delete(Long id);
}
