package servlet;

import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了TestServlet");
        Student s1=new Student("A10001","zs",23);
        Student s2=new Student("A20002","ls",30);
        //{s1:{"id":"?","name":"?","age":?},s2:{"id":"?","name":"?","age":?}} error

        //{"s1":{"id":"?","name":"?","age":?},"s2":{"id":"?","name":"?","age":?}} success
        String str="{\"s1\":{\"id\":\""+s1.getId()
                +"\",\"name\":\""+s1.getName()
                +"\",\"age\":"+s1.getAge()
                +"},\"s2\":{\"id\":\""+s2.getId()
                +"\",\"name\":\""+s2.getName()
                +"\",\"age\":"+s2.getAge()+"}}";
        PrintWriter pw=resp.getWriter();
        pw.print(str);
        pw.close();
    }
}
