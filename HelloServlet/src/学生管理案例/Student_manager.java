package 学生管理案例;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//1. 创建一个 web 项目。
//2. 创建一个用于保存学生信息的html 文件。
//3. 创建一个类，继承HttpServlet。
//4. 重写 doGet 和 doPost 方法。
//5. 在 web.xml 文件中修改默认主页和配置Servlet。
//6. 在 doGet 方法中接收表单数据保存到文件中，并响应给浏览器结果。
//7. 部署并启动项目。
//8. 通过浏览器测试。
public class Student_manager extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
