package com.example.BusStation.web.controller;

import com.example.BusStation.model.Line;
import com.example.BusStation.service.LineService;
import com.example.BusStation.web.dto.LineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/lines", produces = MediaType.APPLICATION_JSON_VALUE)
public class LineController {

    private final LineService lineService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<LineDTO>> getAll(
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String departure,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo
    ) {
        if (
                (destination == null || destination.isBlank())
                        && (departure == null || departure.isBlank())
                        && maxPrice == null
                        && minPrice == null
                        && date == null) {
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        }
        List<LineDTO> lines = lineService.search(date, destination, departure, minPrice, maxPrice, pageNo);
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<LineDTO> getOne(@PathVariable Long id) {
        LineDTO lineDTO = lineService.getOne(id);
        return new ResponseEntity<>(lineDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<LineDTO> save(@RequestBody Line line) {
        LineDTO savedLine = lineService.save(line);
        return new ResponseEntity<>(savedLine, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<LineDTO> update(@PathVariable Long id, @RequestBody Line line) {
        LineDTO updated = lineService.update(line, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
