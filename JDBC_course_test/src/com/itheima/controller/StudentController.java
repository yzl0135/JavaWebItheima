package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.serviceimpl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentController {
    private StudentService ss=new StudentServiceImpl();
    @Test
    public void selectAll(){
        List<Student> students = ss.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void insert(){
        Student stu=new Student(2,"yzl",20);
        int count = ss.insert(stu);
        if(count==1){
            System.out.println("添加成功!");
        }else{
            System.out.println("添加失败!");
        }
    }

    @Test
    public void update(){
        Student stu=new Student(8,"李四",99);
        int count=ss.update(stu);
        if(count==1){
            System.out.println("修改成功!");
        }else{
            System.out.println("修改失败!");
        }
    }

    @Test
    public void delete(){
        int count=ss.delete(8);
        if(count==1){
            System.out.println("删除成功!");
        }else{
            System.out.println("删除失败!");
        }
    }
}
