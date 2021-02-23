package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/image_test01")
public class 图片_test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        String realPath = this.getServletContext().getRealPath("/timg.jpg");
        System.out.println(realPath);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("/timg.jpg"));
        ServletOutputStream os = resp.getOutputStream();
        int len;
        byte[] bytes = new byte[1024];
        while((len=bis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        bis.close();
    }
}
