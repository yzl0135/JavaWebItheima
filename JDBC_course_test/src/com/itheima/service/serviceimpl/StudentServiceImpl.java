package com.itheima.service.serviceimpl;

import com.itheima.dao.StudentDao;
import com.itheima.dao.daoimpl.StudentDaoImpl;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao sd=new StudentDaoImpl();
    @Override
    public List<Student> selectAll() {
        List<Student> students = null;
        try {
            students = sd.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int insert(Student stu) {
        int count = sd.insert(stu);
        return count;
    }

    @Override
    public int update(Student stu) {
        int count = sd.update(stu);
        return count;
    }

    @Override
    public int delete(int i) {
        int count = sd.delete(i);
        return count;
    }

}
