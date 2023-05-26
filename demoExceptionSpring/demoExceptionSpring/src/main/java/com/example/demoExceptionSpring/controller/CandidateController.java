package com.example.demoExceptionSpring.controller;

import com.example.demoExceptionSpring.exception.CandidateNotFoundException;
import com.example.demoExceptionSpring.model.Candidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @GetMapping("/get-info/{id}")
    public ResponseEntity<Object> getCandidateInfo(@PathVariable Integer id) {
        if(id == 1001) {
            Candidate candidate = new Candidate(1001, "Alamin Hossain", "Java");
            return new ResponseEntity<>(candidate, HttpStatus.OK);
        } else {
            throw new CandidateNotFoundException("Candidate not found");
        }
    }
}
