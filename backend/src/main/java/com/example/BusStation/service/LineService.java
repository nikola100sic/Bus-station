package com.example.BusStation.service;

import com.example.BusStation.model.Line;
import com.example.BusStation.web.dto.LineDTO;

import java.util.List;

public interface LineService {

    LineDTO getOne(Long id);

    List<LineDTO> getAll();

    Line save(Line line);

    Line update(Line line);

    Line delete(Long id);
}
