package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/addStu_test04")
public class addStudent_test extends HttpServlet {
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
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\我的文档\\桌面\\Project\\JavaWebItheima\\ReqResp请求与响应\\src\\Student.txt",true));
        bw.write(stu.getUsername()+","+stu.getAge()+","+stu.getScore());
        bw.newLine();
        bw.close();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("添加成功！2秒后自动跳转主页");
        resp.setHeader("REFRESH","2;URL="+this.getServletContext().getContextPath()+"/index.html");
    }
}
