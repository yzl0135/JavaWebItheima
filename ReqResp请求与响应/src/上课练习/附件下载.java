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

@WebServlet("/xz_test03")
public class 附件下载 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath("/timg.jpg");
        System.out.println(realPath);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("/timg.jpg"));
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition","attachment;filename=time.png");
        ServletOutputStream os = resp.getOutputStream();
        int len;
        byte[] bytes = new byte[1024];
        while((len=bis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        bis.close();
    }
}
