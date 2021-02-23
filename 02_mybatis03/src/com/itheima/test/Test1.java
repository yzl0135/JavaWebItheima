package com.itheima.test;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import com.itheima.util.ServiceFactory;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        StudentService ss= (StudentService) ServiceFactory.getService(new StudentServiceImpl());

//        Student s = new Student();
//        s.setId(9);
//        s.setName("cxk");
//        s.setAge(23);
//        ss.save(s);

//        System.out.println("--------------------------------");
//        Student s2 = ss.getById(3);
//        System.out.println(s2);
//        System.out.println("--------------------------------");
//
        List<Student> list = ss.getAll();
        for (Student student : list) {
            System.out.println(student);
        }


    }
}
