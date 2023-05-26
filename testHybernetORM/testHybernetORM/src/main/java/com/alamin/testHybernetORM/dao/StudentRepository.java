package com.alamin.testHybernetORM.dao;

import com.alamin.testHybernetORM.controller.InsufficientBalanceException;
import com.alamin.testHybernetORM.controller.InvalidStudentException;
import com.alamin.testHybernetORM.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long id);

    void transferBalance(Long fromStudentId, Long toStudentId, Double amount) throws InvalidStudentException, InsufficientBalanceException;
}
