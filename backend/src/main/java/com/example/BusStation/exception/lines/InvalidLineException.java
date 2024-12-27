package com.example.BusStation.exception.lines;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidLineException extends RuntimeException {
    
    public InvalidLineException(String message) {
        super(message);
    }
}
