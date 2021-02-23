package com.itheima.dao;

import com.itheima.domain.Student;
import com.itheima.vo.StudentAndClassroomVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student getById(int id);

    public void save(Student s);

    List<Student> getAll();

    Student select1(int i);

    List<Student> select2(int i);

    List<Student> select4(Student st);

    List<Student> select5(HashMap<String, Object> map);

    Student select6(int i);

    List<Student> select7(String y);

    List<Student> select9(String y);

    String select10(int i);

    List<String> select11();

    int select12();

    List<Map<String, Object>> select14();

    List<Student> select15();

    List<Student> select16();

    List<Student> select17(Student s);

    List<Student> select18(Integer[] list);

    List<Map<String, Object>> select20();

    List<StudentAndClassroomVo> select21();

    List<StudentAndClassroomVo> select22(String z);

//    List<Student> select3(String yzl, int i);
}
