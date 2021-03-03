package com.itheima.jdbc;

import javax.xml.transform.Result;
import java.sql.*;

public class test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取连接
        String url="jdbc:mysql://localhost:3306/db1?serverTimezone=UTC";
        String username="root";
        String password="root";
        Connection con= DriverManager.getConnection(url,username,password);
        //4.获取执行者对象
        Statement statement = con.createStatement();
        //5.执行sql语句，并且接收结果
        String sql="SELECT * FROM student";
        ResultSet rs=statement.executeQuery(sql);
        //6.处理结果
        while(rs.next()){
            System.out.println(rs.getInt("id")+"\t"+rs.getString("name"));
        }
        //7.释放资源
        rs.close();
        statement.cancel();
        con.close();
    }
}
