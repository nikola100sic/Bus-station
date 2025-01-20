package com.example.BusStation.exception.carriers;

public class CarrierNotFoundException extends RuntimeException {
    public CarrierNotFoundException(Long id) {
        super("Carrier with id: " + id + " not found");
    }
}
