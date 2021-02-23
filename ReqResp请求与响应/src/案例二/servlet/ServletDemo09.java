package 案例二.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Path;

@WebServlet("/servletDemo09")
@MultipartConfig
public class ServletDemo09 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File upload_path = new File(this.getServletContext().getRealPath("/upload"));
        if (!upload_path.exists()) {
            upload_path.mkdirs();
        }
        req.setCharacterEncoding("utf-8");

        Part upload_file = req.getPart("upload_file");
        String fileName = upload_file.getSubmittedFileName();
        String header = req.getHeader("user-agent");
        System.out.println(header);
        if (header.contains("Chrome") || header.contains("Firefox")) {
            System.out.println(fileName);
        }  else {
            fileName = fileName.split(":")[1];
        }

        InputStream is = upload_file.getInputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(upload_path + File.separator + fileName));
        System.out.println(upload_path + File.separator + fileName);
        byte[] arr = new byte[1024 * 8];
        int len;
        while ((len = is.read(arr)) != -1) {
            bufferedOutputStream.write(arr, 0, len);
        }
        bufferedOutputStream.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
