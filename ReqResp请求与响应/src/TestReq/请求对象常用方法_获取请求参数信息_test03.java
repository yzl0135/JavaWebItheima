package TestReq;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class 请求对象常用方法_获取请求参数信息_test03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String getParameter(String name) 根据名称获取数据
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println("-------------");
//        String[] getParameterValues(String name) 根据名称获取所有数据
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("-------------");
//        Enumeration<String> getParameterNames() 获取所有名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);
            System.out.println(name + "---" + value);
        }
        System.out.println("-------------");
//        Map<String,String[]> getParameterMap() 获取所有参数的键值对
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((k, v) -> System.out.println(k + "-" + v));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
