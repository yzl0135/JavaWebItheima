package stu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class studentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        BufferedWriter bw=new BufferedWriter(new FileWriter("HelloServlet\\src\\stu.txt",true));
        bw.write(username+"-"+age+"-"+score);
        bw.newLine();
        bw.close();

        PrintWriter pw=resp.getWriter();
        pw.println("save success");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
