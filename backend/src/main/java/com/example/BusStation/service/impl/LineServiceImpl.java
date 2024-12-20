package com.example.BusStation.service.impl;

import com.example.BusStation.model.Line;
import com.example.BusStation.service.LineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Override
    public Line getOne(Long id) {
        return null;
    }

    @Override
    public List<Line> getAll() {
        return List.of();
    }

    @Override
    public Line save(Line line) {
        return null;
    }

    @Override
    public Line update(Line line) {
        return null;
    }

    @Override
    public Line delete(Long id) {
        return null;
    }
}
