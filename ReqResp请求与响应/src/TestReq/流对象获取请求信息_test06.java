package TestReq;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test06")
public class 流对象获取请求信息_test06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //字符流(必须是post方式)
        /*BufferedReader br = req.getReader();
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);   // getQueryString();
        }*/
        //br.close();
        //字节流
        ServletInputStream sis =req.getInputStream();
        int len;
        byte[] arr = new byte[1024];
        while((len=sis.read(arr))!=-1){
            System.out.println(new String(arr,0,len));
        }
//        sis.close();

        req.getRequestDispatcher("/servletDemo08").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
