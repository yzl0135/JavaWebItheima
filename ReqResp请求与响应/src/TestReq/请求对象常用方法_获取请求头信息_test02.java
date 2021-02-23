package TestReq;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class 请求对象常用方法_获取请求头信息_test02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String getHeader(String name) 根据请求头名称获取一个值
        String connection = req.getHeader("connection");
        System.out.println("1:" + connection);
        System.out.println("-------------------------");
//        Enumeration<String> getHeaders(String name) 根据请求头名称获取多个值
        Enumeration<String> headers = req.getHeaders("accept-encoding");
        while (headers.hasMoreElements()) {
            String s = headers.nextElement();
            System.out.println("2:" + s);
        }
        System.out.println("--------------------------");
//        Enumeration<String> getHeaderNames() 获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
