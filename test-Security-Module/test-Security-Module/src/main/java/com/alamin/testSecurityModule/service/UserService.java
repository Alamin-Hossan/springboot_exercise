package com.alamin.testSecurityModule.service;

import com.alamin.testSecurityModule.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
}
