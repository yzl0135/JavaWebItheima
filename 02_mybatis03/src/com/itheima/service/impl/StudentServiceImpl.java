package com.itheima.service.impl;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao= SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(int num) {
        Student s = studentDao.getById(num);
        return s;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = studentDao.getAll();
        return list;
    }

    @Override
    public void save(Student s) {
        studentDao.save(s);
    }
}
