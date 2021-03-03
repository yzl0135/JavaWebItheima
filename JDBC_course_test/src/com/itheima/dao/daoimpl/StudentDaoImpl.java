package com.itheima.dao.daoimpl;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectAll(){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Student> list=new ArrayList<>();
        //1.导入jar包
        //2.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3.获取连接
            String url="jdbc:mysql://localhost:3306/db2?serverTimezone=UTC";
            String username="root";
            String password="root";
            con= DriverManager.getConnection(url,username,password);
            //4.获取执行者对象
            st = con.createStatement();
            //5.执行sql语句，并且接收结果
            String sql="SELECT * FROM student";
            rs=st.executeQuery(sql);
            //6.处理结果
            while(rs.next()){
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                Integer age = rs.getInt("age");
                Student stu=new Student(id,name,age);
                list.add(stu);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.cancel();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int insert(Student stu) {
        Connection con = null;
        Statement st = null;
        int result = 0;
        //1.导入jar包
        //2.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3.获取连接
            String url="jdbc:mysql://localhost:3306/db2?serverTimezone=UTC";
            String username="root";
            String password="root";
            con= DriverManager.getConnection(url,username,password);
            //4.获取执行者对象
            st = con.createStatement();
            //5.执行sql语句，并且接收结果
            Integer id = stu.getId();
            String name = stu.getName();
            Integer age = stu.getAge();
            String sql="insert into student values('"+id+"','"+name+"','"+age+"')";
            result=st.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            try {
                st.cancel();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int update(Student stu) {
        Connection con = null;
        Statement st = null;
        int result = 0;
        //1.导入jar包
        //2.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3.获取连接
            String url = "jdbc:mysql://localhost:3306/db2?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(url, username, password);
            //4.获取执行者对象
            st = con.createStatement();
            //5.执行sql语句，并且接收结果
            Integer id = stu.getId();
            String name = stu.getName();
            Integer age = stu.getAge();
            String sql = "update student set name='"+name+"',age='"+age+"' where id='"+id+"'";
            result = st.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            try {
                st.cancel();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delete(int i) {
        Connection con = null;
        Statement st = null;
        int result = 0;
        //1.导入jar包
        //2.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3.获取连接
            String url = "jdbc:mysql://localhost:3306/db2?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(url, username, password);
            //4.获取执行者对象
            st = con.createStatement();
            //5.执行sql语句，并且接收结果
            String sql = "delete from student where id='"+i+"'";
            result = st.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            try {
                st.cancel();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
