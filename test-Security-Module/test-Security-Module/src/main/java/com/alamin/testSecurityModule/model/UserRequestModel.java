package com.alamin.testSecurityModule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestModel {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
