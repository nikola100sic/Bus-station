package com.example.BusStation.web.controller;

import com.example.BusStation.model.Line;
import com.example.BusStation.service.LineService;
import com.example.BusStation.web.dto.LineDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/lines", produces = MediaType.APPLICATION_JSON_VALUE)
public class LineController {

    private final LineService lineService;

    @GetMapping
    public ResponseEntity<List<LineDTO>> getAll() {
        List<LineDTO> lines = lineService.getAll();
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Line> save(@RequestBody Line line) {
        Line savedLine = lineService.save(line);
        return new ResponseEntity<>(line, HttpStatus.OK);
    }
}
