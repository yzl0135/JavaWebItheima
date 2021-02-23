package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/find_test")
public class listStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br=new BufferedReader(new FileReader("D:\\我的文档\\桌面\\Project\\JavaWebItheima\\Cookie&Session&Jsp\\src\\StudentInfo.txt"));
        ArrayList<Student> list=new ArrayList<>();
        String line;
        while((line=br.readLine())!=null){
            Student stu=new Student();
            String[] split = line.split(",");
            stu.setUsername(split[0]);
            stu.setAge(Integer.parseInt(split[1]));
            stu.setScore(Integer.parseInt(split[2]));
            list.add(stu);
        }
        br.close();
        HttpSession session = req.getSession();
        session.setAttribute("list",list);
        resp.sendRedirect(this.getServletContext().getContextPath()+"/listStudent.jsp");
    }
}
