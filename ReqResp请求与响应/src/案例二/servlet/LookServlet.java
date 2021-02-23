package 案例二.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lookServlet")
public class LookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从文件中读取数据，响应给浏览器
        // 真实路径
        String realPath = this.getServletContext().getRealPath("/student_info.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
        String s ;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        while((s = bufferedReader.readLine())!= null){
            writer.write(s);
            writer.write("<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
