package com.itheima.test;

import com.itheima.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = sqlSession.selectOne("test01.getById", "1");
        System.out.println(stu);
        System.out.println("------------------------------------------");
        List<Student> list = sqlSession.selectList("test01.getAll");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("------------------------------------------");
        Student stu2=new Student(5,"YZL02",30);
        sqlSession.insert("test01.insert",stu2);
        System.out.println("------------------------------------------");
        Student stu3=new Student(1,"李四",50);
        sqlSession.update("test01.update",stu3);
        System.out.println("------------------------------------------");
        sqlSession.delete("test01.delete","2");
        sqlSession.commit();
        sqlSession.close();
    }
}
