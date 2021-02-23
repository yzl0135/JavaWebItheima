package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login_test")
public class loginStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username==null || username.equals("")){
            resp.sendRedirect(this.getServletContext().getContextPath()+"/login.jsp");
            return ;
        }

        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        resp.sendRedirect(this.getServletContext().getContextPath()+"/index.jsp");
    }
}
