package com.itheima.dao;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentDao {
    public abstract List<Student> selectAll();

    public int insert(Student stu);

    int update(Student stu);

    int delete(int i);
}
