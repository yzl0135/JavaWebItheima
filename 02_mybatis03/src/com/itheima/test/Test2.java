package com.itheima.test;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.util.SqlSessionUtil;
import com.itheima.vo.StudentAndClassroomVo;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

        //1.测试：parameterType 使用简单数据类型 String
//        Student st=studentDao.select1(4);
//        System.out.println(st);

        //2.测试：parameterType 使用简单数据类型 int
//        List<Student> list=studentDao.select2(30);
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //3.测试：parameterType
        //需求：查询出姓名为yzl，年龄为20岁的学员信息
          /*

            绝对不可以像下面的案例一样，同时为sql语句传递多个参数

         */
//        List<Student> list=studentDao.select3("yzl",20);
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //4.测试：parameterType，使用domain为参数 Student s
        //需求：查询出姓名为yzl，年龄为20岁的学员信息
//        Student st=new Student();
//        st.setName("yzl");
//        st.setAge(20);
//        List<Student> list=studentDao.select4(st);
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //5.测试：parameterType，使用map为参数
        //需求：查询出姓名为yzl，年龄为20岁的学员信息
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("name","yzl");
//        map.put("age",20);
//        List<Student> list=studentDao.select5(map);
//        for (Student student : list) {
//            System.out.println(student);
//        }

//        //6.测试：根据id查单条 sql使用${}来接收值
//        Student st=studentDao.select6(9);
//        System.out.println(st);

        //7.测试：like模糊查询 方式1：使用${} 了解
//        List<Student> list=studentDao.select7("y");
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //8.测试：like模糊查询 方式2：使用#{} 了解
        /*List<Student> sList = studentDao.select8("%y%");
        for(Student s1:sList){
            System.out.println(s1);
        }*/


        //9.测试：like模糊查询 方式3：使用#{} 掌握
//        List<Student> list=studentDao.select9("y");
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //10.测试：resultType 返回String类型
        //需求：查询出编号为4的学员的姓名
//        String name=studentDao.select10(4);
//        System.out.println(name);

        //11.测试：resultType 返回String类型集合
        //需求：查询出所有学生的姓名
//        List<String> names=studentDao.select11();
//        for (String name : names) {
//            System.out.println(name);
//        }

        //12.测试：resultType 返回int类型
        //需求：查询出表中一共有多少条信息
//        int count=studentDao.select12();
//        System.out.println(count);

        //13.测试：resultType 返回domain引用类型Student 略过

        //14.测试：resultType 返回map类型
//        List<Map<String,Object>> list=studentDao.select14();
//        for (Map<String, Object> map : list) {
//            Set<String> strings = map.keySet();
//            for (String string : strings) {
//                System.out.println("key:"+string);
//                System.out.println("value:"+map.get(string));
//            }
//            System.out.println("----------------------------------------------");
//        }

        //15.测试 resultType 当数据库表字段名称和domain类属性名称不一致时的处理 方式1：起别名
//        List<Student> list=studentDao.select15();
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //16.测试 resultType 当数据库表字段名称和domain类属性名称不一致时的处理 方式2：使用resultMap
//        List<Student> list=studentDao.select16();
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //17.测试:动态sql where标签+if标签
//        Student s = new Student();
//        s.setName("y");
//        s.setAddress("a");
//        List<Student> list=studentDao.select17(s);
//        for (Student student : list) {
//            System.out.println(student);
//        }

        //18.测试:动态sql foreach标签
        //查询编号为1,2,3的学员信息
//       Integer arr[]={1,2,3};
//        List<Student> list2=studentDao.select18(arr);
//        for (Student student : list2) {
//            System.out.println(student);
//        }

        //20.测试:多表联查  查询出学生姓名和班级名称
//        List<Map<String,Object>> list=studentDao.select20();
//        for (Map<String, Object> map : list) {
//            Set<String> set = map.keySet();
//            for (String key : set) {
//                System.out.println("key:"+key);
//                System.out.println("value:"+map.get(key));
//            }
//            System.out.println("-----------------------------------");
//        }

        //21.测试:多表联查 查询出学生和班级所有信息，加VO
//        List<StudentAndClassroomVo> list=studentDao.select21();
//        for (StudentAndClassroomVo studentAndClassroomVo : list) {
//            System.out.println(studentAndClassroomVo);
//        }

        //22.测试:多表联查 查询出带有字母z的学生和班级所有信息
        List<StudentAndClassroomVo> list=studentDao.select22("y");
        for (StudentAndClassroomVo studentAndClassroomVo : list) {
            System.out.println(studentAndClassroomVo);
        }

    }
}
