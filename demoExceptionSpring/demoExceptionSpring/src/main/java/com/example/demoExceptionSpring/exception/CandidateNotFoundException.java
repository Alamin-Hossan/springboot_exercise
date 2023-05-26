package com.example.demoExceptionSpring.exception;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(String message){
        super(message);
    }
}
