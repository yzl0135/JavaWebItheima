package TestResp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test0203")
public class 设置缓存_test0203 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String news="这是一条很火爆的消息！";
        //设置缓存  1小时的缓存时间
        resp.setDateHeader("Expries",System.currentTimeMillis()+ 1*60*60*1000);
        //设置编码格式
        resp.setContentType("text/html;charset=utf-8");
        //写出数据
        resp.getWriter().write(news);

        System.out.println("aaa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
