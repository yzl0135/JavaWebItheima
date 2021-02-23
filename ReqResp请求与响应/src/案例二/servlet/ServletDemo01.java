package 案例二.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    字节流响应消息
 */
@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        resp.setContentType("text/xml;charset=UTF-8");
        //1.获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();
        //2.定义一个消息
        String str = "<a href='https://www.baidu.com'>点我</a>";
        //3.通过字节流对象输出
        os.write(str.getBytes("UTF-8"));
        //os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
