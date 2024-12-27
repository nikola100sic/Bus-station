package com.example.BusStation.service;

import com.example.BusStation.model.Line;
import com.example.BusStation.web.dto.LineDTO;

import java.util.List;

public interface LineService {

    LineDTO getOne(Long id);

    List<LineDTO> getAll();

    LineDTO save(Line line);

    LineDTO update(Line line, Long id);

    void delete(Long id);
}
