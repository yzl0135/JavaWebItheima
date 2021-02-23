package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Author 北京动力节点
 */
public class MyServlet05 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到学生模块相关操作");

        //取得url-pattern
        String path = request.getServletPath();

        if("/student/save.do".equals(path)){

            save(request,response);

        }else if("/student/update.do".equals(path)){

            update(request,response);

        }else if("/student/delete.do".equals(path)){

            delete(request,response);


        }else if("/student/select.do".equals(path)){

            select(request,response);

        }

    }

    private void select(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行查询操作");

    }


    private void delete(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行删除操作");

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行修改操作");

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行添加操作");

    }


}
