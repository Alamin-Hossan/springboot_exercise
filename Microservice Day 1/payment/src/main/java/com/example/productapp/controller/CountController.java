package com.example.productapp.controller;

import com.example.productapp.PaymentApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    @GetMapping("/getCount")
    public Integer getCount(){
        return PaymentApplication.COUNTER++;
    }

}
