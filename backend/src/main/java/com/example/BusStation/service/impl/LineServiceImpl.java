package com.example.BusStation.service.impl;

import com.example.BusStation.model.Carrier;
import com.example.BusStation.model.Line;
import com.example.BusStation.repository.LineRepository;
import com.example.BusStation.service.LineService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LineServiceImpl implements LineService {

    private final LineRepository lineRepository;

    @Override
    public Line getOne(Long id) {
        return lineRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity with ID " + id + " not found"));
    }

    @Override
    public List<Line> getAll() {
        return lineRepository.findAll();
    }

    @Override
    public Line save(Line line) {
        return lineRepository.save(line);
    }

    @Override
    public Line update(Line line) {
        if (line == null || line.getId() == null) {
            throw new IllegalArgumentException("Line or Line ID must not be null.");
        }
        Line existingLine = lineRepository.findById(line.getId())
                .orElseThrow(() -> new EntityNotFoundException("Line with ID " + line.getId() + " not found."));
        return lineRepository.save(line);
    }

    @Override
    public Line delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null.");
        }
        Line line = lineRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Line with ID: " + id + " not found"));
        lineRepository.delete(line);
        return line;
    }
}
