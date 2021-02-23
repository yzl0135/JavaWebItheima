package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/listStu_test05")
public class listStudent_test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br=new BufferedReader(new FileReader("D:\\我的文档\\桌面\\Project\\JavaWebItheima\\ReqResp请求与响应\\src\\Student.txt"));
        ArrayList<Student> list=new ArrayList<>();
        String line;
        while((line=br.readLine())!=null){
            Student stu=new Student();
            String[] arr = line.split(",");
            stu.setUsername(arr[0]);
            stu.setAge(Integer.parseInt(arr[1]));
            stu.setScore(Integer.parseInt(arr[2]));
            list.add(stu);
        }
        br.close();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        for (Student student : list) {
            pw.write(student.getUsername()+","+student.getAge()+","+student.getScore());
            pw.write("<br>");
        }
    }
}
