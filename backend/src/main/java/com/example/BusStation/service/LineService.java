package com.example.BusStation.service;

import com.example.BusStation.model.Line;

import java.util.List;

public interface LineService {

    Line getOne(Long id);

    List<Line> getAll();

    Line save(Line line);

    Line update(Line line);

    Line delete(Long id);
}
