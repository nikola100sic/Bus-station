package com.example.BusStation.service.impl;

import com.example.BusStation.converter.LineConverter;
import com.example.BusStation.exception.lines.InvalidLineException;
import com.example.BusStation.exception.lines.LineNotFoundException;
import com.example.BusStation.model.Line;
import com.example.BusStation.repository.LineRepository;
import com.example.BusStation.service.LineService;
import com.example.BusStation.web.dto.LineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LineServiceImpl implements LineService {

    private final LineRepository lineRepository;

    private final LineConverter lineConverter;

    @Override
    public LineDTO getOne(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(() -> new LineNotFoundException(id));
        return lineConverter.toDto(line);
    }

    @Override
    public List<LineDTO> getAll() {
        return lineRepository.findAll()
                .stream()
                .map(lineConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LineDTO save(Line line) {
        Line savedLine = lineRepository.save(line);
        return lineConverter.toDto(savedLine);
    }

    @Override
    public LineDTO update(Line line, Long id) {
        if (line == null || line.getId() == null || !line.getId().equals(id)) {
            throw new InvalidLineException("Invalid Line data: Line ID must not be null and must match the path ID.");
        }
        Line existingLine = lineRepository.findById(id)
                .orElseThrow(() -> new LineNotFoundException(id));
        lineRepository.save(line);
        return lineConverter.toDto(line);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null.");
        }
        Line line = lineRepository.findById(id).orElseThrow(() ->
                new LineNotFoundException(id));
        lineRepository.delete(line);
    }
}
