package com.alamin.testSecurityModule.repository;

import com.alamin.testSecurityModule.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public UserEntity findByEmail(String email);

}
