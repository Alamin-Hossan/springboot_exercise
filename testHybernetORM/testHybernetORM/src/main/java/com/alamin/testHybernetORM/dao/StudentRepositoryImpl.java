package com.alamin.testHybernetORM.dao;

import com.alamin.testHybernetORM.controller.InsufficientBalanceException;
import com.alamin.testHybernetORM.controller.InvalidStudentException;
import com.alamin.testHybernetORM.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).getResultList();
        }
    }

    @Override
    public Student getStudentById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public Student createStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return student;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
            return student;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.remove(student);
            transaction.commit();
        }
    }
    @Override
    public void transferBalance(Long fromStudentId, Long toStudentId, Double amount) throws InvalidStudentException, InsufficientBalanceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Student fromStudent = session.get(Student.class, fromStudentId);
            if (fromStudent == null) {
                throw new InvalidStudentException("Invalid 'fromStudentId' provided");
            }

            Student toStudent = session.get(Student.class, toStudentId);
            if (toStudent == null) {
                throw new InvalidStudentException("Invalid 'toStudentId' provided");
            }

            if (fromStudent.getBalance() < amount) {
                throw new InsufficientBalanceException("Insufficient balance for transfer");
            }

            fromStudent.setBalance(fromStudent.getBalance() - amount);
            toStudent.setBalance(toStudent.getBalance() + amount);

            session.update(fromStudent);
            session.update(toStudent);

            transaction.commit();
        } catch (Exception e) {
            // Rollback the transaction in case of any exception
            if (transaction != null) {
                transaction.rollback();
            }

            // Rethrow the exception for the higher layer to handle
            if (e instanceof InvalidStudentException) {
                throw (InvalidStudentException) e;
            } else if (e instanceof InsufficientBalanceException) {
                throw (InsufficientBalanceException) e;
            } else {
                throw new RuntimeException("An error occurred during balance transfer", e);
            }
        }
    }

}
