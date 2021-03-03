package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> selectAll();

    public abstract int insert(Student stu);

    int update(Student stu);

    int delete(int i);
}
