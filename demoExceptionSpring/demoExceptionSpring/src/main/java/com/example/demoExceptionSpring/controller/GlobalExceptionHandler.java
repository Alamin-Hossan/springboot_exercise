package com.example.demoExceptionSpring.controller;

import com.example.demoExceptionSpring.exception.AdminNotFoundException;
import com.example.demoExceptionSpring.exception.CandidateNotFoundException;
import com.example.demoExceptionSpring.exception.TrainerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({AdminNotFoundException.class, CandidateNotFoundException.class, TrainerNotFoundException.class})
    public ResponseEntity<Object> notFoundException(Exception exception){
        if(exception instanceof CandidateNotFoundException){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } else if (exception instanceof AdminNotFoundException) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } else if (exception instanceof TrainerNotFoundException) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
