package com.example.service;

import com.example.domain.Student;

import java.util.List;

public interface StudentService {

    void insert(Object[] args);

    Student findById(Long id);

    List<Student> findAll();

    int[] batchInsert(List<Object[]> objects);

}
