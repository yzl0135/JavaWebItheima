package 课堂练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/test01_kt")
public class Test01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        BufferedWriter bw=new BufferedWriter(new FileWriter("d:\\stu.txt",true));
        bw.write(name+","+age+","+score);
        bw.newLine();
        bw.flush();
        bw.close();

        PrintWriter writer = resp.getWriter();
        writer.println("save success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
