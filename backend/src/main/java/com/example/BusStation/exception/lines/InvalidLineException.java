package com.example.BusStation.exception.lines;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException(String message) {
        super(message);
    }
}
