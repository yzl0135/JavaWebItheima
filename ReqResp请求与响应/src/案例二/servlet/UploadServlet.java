package 案例二.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/uploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取upload文件夹的真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath(servletContext.getContextPath() + "/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 把上传的数据给读进来
        Part part = req.getPart("upload_file");
        InputStream is = part.getInputStream();// 获取浏览器发送过来的二进制流对象
        String fileName = part.getSubmittedFileName();  // 获取文件名称
        System.out.println(fileName);
        // ie： C      UsersAdministratorDesktopJavaSE.png   JavaSE.png
        String header = req.getHeader("user-agent");
        if (!(header.contains("Firefox") || header.contains("Chrome"))) {
            fileName = fileName.split(":")[1];
        }

        // 获取写出数据的流对象
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(realPath + File.separator + fileName));

        byte[] arr = new byte[1024 * 8];
        int len;
        while ((len = is.read(arr)) != -1) {
            bufferedOutputStream.write(arr, 0, len);
        }
        bufferedOutputStream.close();

    }

}
