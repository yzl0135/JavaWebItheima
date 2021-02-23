package Servlet快速入门;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

//1. 创建一个 WEB 项目。
//2. 创建一个类继承GenericServlet。
//3. 重写 service 方法。
//4. 在 web.xml 中配置 Servlet。
//5. 部署并启动项目。
//6. 通过浏览器测试。
public class HelloServlet01 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,Servlet01!");
    }
}
