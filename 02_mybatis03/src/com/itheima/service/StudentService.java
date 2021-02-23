package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {
    Student getById(int num);

    List<Student> getAll();

    void save(Student s);
}
