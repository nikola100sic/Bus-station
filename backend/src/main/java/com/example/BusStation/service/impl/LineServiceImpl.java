package com.example.BusStation.service.impl;

import com.example.BusStation.converter.LineMapper;
import com.example.BusStation.model.Line;
import com.example.BusStation.repository.LineRepository;
import com.example.BusStation.service.LineService;
import com.example.BusStation.web.dto.LineDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LineServiceImpl implements LineService {

    private final LineRepository lineRepository;

    private final LineMapper lineMapper;

    @Override
    @Transactional
    public LineDTO getOne(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity with ID " + id + " not found"));
        return lineMapper.toDto(line);
    }

    @Override
    @Transactional
    public List<LineDTO> getAll() {
        return lineRepository.findAll()
                .stream()
                .map(lineMapper::toDto)
                .collect(Collectors.toList());
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
