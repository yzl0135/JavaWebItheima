package TestResp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test0202")
public class 字节流响应消息_test0202 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png;charset=UTF-8");

        //1.获取字符输出流对象
        PrintWriter pw = resp.getWriter();

        //2.准备一个消息
        String str = "<a href='https://www.baidu.com'>点我</a>";

        //3.通过字符流输出
        pw.write(str);

        //pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
