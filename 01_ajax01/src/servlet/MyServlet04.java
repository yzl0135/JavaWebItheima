package servlet;


import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author 北京动力节点
 */
public class MyServlet04 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到servlet04");

        Student s1 = new Student("A0001","zs",23);
        Student s2 = new Student("A0002","ls",24);

        //{"id":"?","name":"?","age":?}
        //{"s1":{"id":"?","name":"?","age":?},"s2":{"id":"?","name":"?","age":?}}
        String str = "{\"s1\":{\"id\":\""+s1.getId()
                +"\",\"name\":\""+s1.getName()
                +"\",\"age\":"+s1.getAge()
                +"},\"s2\":{\"id\":\""+s2.getId()
                +"\",\"name\":\""+s2.getName()
                +"\",\"age\":"+s2.getAge()+"}}";

        PrintWriter out = response.getWriter();
        out.print(str);
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);

    }
}
