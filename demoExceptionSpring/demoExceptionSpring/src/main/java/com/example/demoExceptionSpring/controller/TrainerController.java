package com.example.demoExceptionSpring.controller;

import com.example.demoExceptionSpring.exception.TrainerNotFoundException;
import com.example.demoExceptionSpring.model.Trainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @GetMapping("/get-info/{id}")
    public ResponseEntity<Object> getAdminInfo(@PathVariable Integer id) throws TrainerNotFoundException {
        if (id == 1) {
            Trainer trainer = new Trainer(131, "John", "Java");
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            throw new TrainerNotFoundException("Trainer not found.");
        }
    }

}
