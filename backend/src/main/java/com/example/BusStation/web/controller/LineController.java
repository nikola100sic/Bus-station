package com.example.BusStation.web.controller;

import com.example.BusStation.model.Line;
import com.example.BusStation.service.LineService;
import com.example.BusStation.web.dto.LineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/lines", produces = MediaType.APPLICATION_JSON_VALUE)
public class LineController {

    private final LineService lineService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<LineDTO>> getAll(@RequestParam(required = false) Long carrierId,
                                                @RequestParam(required = false) String destination,
                                                @RequestParam(required = false) Integer maxPrice,
                                                @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
        List<LineDTO> lines = lineService.search(carrierId, destination, maxPrice, pageNo);
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
