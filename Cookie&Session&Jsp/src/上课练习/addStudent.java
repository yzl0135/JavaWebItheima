package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/add_test")
public class addStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");
        Student stu=new Student(username,Integer.parseInt(age),Integer.parseInt(score));
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\我的文档\\桌面\\Project\\JavaWebItheima\\Cookie&Session&Jsp\\src\\StudentInfo.txt",true));
        bw.write(stu.getUsername()+","+stu.getAge()+","+stu.getScore());
        bw.newLine();
        bw.close();

        resp.getWriter().write("添加成功！2秒后跳转到主页");
        resp.setHeader("Refresh","2;URL="+this.getServletContext().getContextPath()+"/index.jsp");
    }
}
