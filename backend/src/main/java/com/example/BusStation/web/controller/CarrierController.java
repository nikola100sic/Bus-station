package com.example.BusStation.web.controller;

import com.example.BusStation.model.Carrier;
import com.example.BusStation.service.CarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/carriers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarrierController {

    private final CarrierService carrierService;

    @GetMapping
    public ResponseEntity<List<Carrier>> getAll() {
        List<Carrier> carriers = carrierService.getAll();
        return new ResponseEntity<>(carriers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getOne(@PathVariable Long id) {
        Carrier carrier = carrierService.getOne(id);
        return new ResponseEntity<>(carrier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carrier> add(@RequestBody Carrier carrier) {
        Carrier saved = carrierService.save(carrier);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}
