package test;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.ServiceFactory;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        //StudentService ss = new StudentServiceImpl();
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

        //测试添加操作
        /*Student s = new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        ss.save(s);*/

        //测试根据id查单条操作
        /*Student s = ss.getById("A0003");
        System.out.println(s);*/

        //查询所有记录
        List<Student> sList = ss.getAll();
        for(Student s:sList){

            System.out.println(s);

        }


    }

}






























