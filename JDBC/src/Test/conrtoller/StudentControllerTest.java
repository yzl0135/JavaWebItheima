package Test.conrtoller;


import Test.domain.Student;
import Test.service.StudentService;
import Test.service.serviceimpl.StudentServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentControllerTest {
    private StudentService service = new StudentServiceImpl();
    /*
        查询所有学生信息
     */
    @Test
    public void findStu(){
        ArrayList<Student> arr = service.findAll();
        for (Student student : arr) {
            System.out.println(student);
        }

    }
    /*
        条件查询，根据id查询学生信息
     */
    @Test
    public void findStuById() {
        Student stu = service.findById(3);
        System.out.println(stu);
    }
    /*
        添加学生信息
     */
    @Test
    public void insertStu() throws ParseException {
        String s="2000-07-06";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(s);
        Student stu=new Student(null,"yzl",20,parse);
        int num = service.insert(stu);
        if(num==0){
            System.out.println("添加失败");
        }else{
            System.out.println("添加成功");
        }
    }
     /*
        删除学生信息
     */
     @Test
    public void deleteStu(){
         int num = service.delete(2);
         if(num==0){
             System.out.println("删除失败");
         }else{
             System.out.println("删除成功");
         }
     }
}
