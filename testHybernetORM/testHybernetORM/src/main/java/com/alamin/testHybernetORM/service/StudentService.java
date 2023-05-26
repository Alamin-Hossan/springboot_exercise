package com.alamin.testHybernetORM.service;

import com.alamin.testHybernetORM.dao.StudentRepository;
import com.alamin.testHybernetORM.dao.StudentRepositoryImpl;
import com.alamin.testHybernetORM.controller.InsufficientBalanceException;
import com.alamin.testHybernetORM.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentRepositoryImpl studentRepositoryimpl;

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public void transferBalance(Long fromStudentId, Long toStudentId, double amount) throws Exception, InsufficientBalanceException {
        studentRepository.transferBalance(fromStudentId, toStudentId, amount);
    }

}
