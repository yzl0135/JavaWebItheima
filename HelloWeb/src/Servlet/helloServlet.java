package Servlet;

import javax.servlet.*;
import java.io.IOException;

//案例 发布动态资源
////        实现步骤
////        1. 创建一个 JavaWEB 项目。
////        2. 将静态页面所需资源导入到项目的web 目录下。
////        3. 修改 web.xml 配置文件，修改默认主页。
////        4. 在项目的 src 路径下编写一个类，实现Servlet 接口。
////        5. 重写 service 方法，输出一句话即可。
////        6. 修改 web.xml 配置文件，配置 servlet 相关资源。
////        7. 将项目部署到 tomcat 中。
////        8. 启动 tomcat 服务。
////        9. 打开浏览器测试功能。
public class helloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
