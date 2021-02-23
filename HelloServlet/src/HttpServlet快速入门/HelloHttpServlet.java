package HttpServlet快速入门;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//HttpServlet 快速入门
//1. 创建一个类继承HttpServlet。
//2. 重写 doGet 和 doPost 方法。
//3. 在 web.xml 中配置 Servlet。
//4. 部署并启动项目。
//5. 通过浏览器测试。
public class HelloHttpServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello,HttpServlet!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
