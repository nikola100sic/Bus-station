package com.example.BusStation.exception.lines;

public class LineNotFoundException extends RuntimeException {
    
    public LineNotFoundException(Long id) {
        super("Line with id: " + id + " not found");
    }
}
