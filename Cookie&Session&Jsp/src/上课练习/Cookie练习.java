package 上课练习;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie_test01")
public class Cookie练习 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        PrintWriter pw = resp.getWriter();
        if (cookies == null || cookies.length == 0) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY年-MM月-dd日 HH时-mm分-ss秒");
            String format = sdf.format(date);
            String encode = URLEncoder.encode(format);
            Cookie cookie = new Cookie("time", encode);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
            pw.write("<h1>您好！欢迎您首次访问！</h1>");
        }

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("time".equals(name)) {
                    String decode = URLDecoder.decode(cookie.getValue());
                    pw.write("<h1>您好！您最后访问时间为" + decode + "</h1>");
                }
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY年-MM月-dd日 HH时-mm分-ss秒");
            String format = sdf.format(date);
            String encode = URLEncoder.encode(format);
            Cookie cookie = new Cookie("time", encode);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
        }
    }
}
