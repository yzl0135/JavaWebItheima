package TestReq;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class 请求对象常用方法_获取各种路径_test01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String getContextPath() 获取虚拟目录名称
        String contextPath = req.getContextPath();
        System.out.println("1:" + contextPath);
//        String getServletPath() 获取Servlet映射路径
        String servletPath = req.getServletPath();
        System.out.println("2:" + servletPath);
//        String getRemoteAddr() 获取访问者ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("3:" + remoteAddr);
//        String getQueryString() 获取请求的消息数据
        String queryString = req.getQueryString();
        System.out.println("4:" + queryString);
//        String getRequestURI() 获取统一资源标识符
        String requestURI = req.getRequestURI();
        System.out.println("5:" + requestURI);
//        StringBuffer getRequestURL() 获取统一资源定位符
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("6:" + requestURL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
