package com.example.demoExceptionSpring.exception;

import com.example.demoExceptionSpring.model.Trainer;

public class TrainerNotFoundException extends Exception{
    public TrainerNotFoundException(String message){
        super(message);
    }
}
