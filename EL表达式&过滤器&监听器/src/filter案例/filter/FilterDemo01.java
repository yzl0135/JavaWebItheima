package filter案例.filter;

import javax.servlet.*;
import java.io.IOException;

/*
    过滤器基本使用
 */
//@WebFilter("/*")
public class FilterDemo01 implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo01执行了...");

        //处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
