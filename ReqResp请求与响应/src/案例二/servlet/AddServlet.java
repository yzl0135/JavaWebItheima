package 案例二.servlet;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求数据
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();

        Student s = new Student();
        try {
            BeanUtils.populate(s,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 将数据写入文件
        String realPath = this.getServletContext().getRealPath("/student_info.txt");
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(realPath,true),true);
        printWriter.println(s.toString());
        printWriter.close();

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write("保存成功！2秒之后自动跳转到首页！");
        resp.setHeader("Refresh","2;URL=/respson/html/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
