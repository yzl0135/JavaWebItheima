package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class filter_test01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("对象初始化成功了....");
        //获取过滤器名称
        String filterName = filterConfig.getFilterName();
        System.out.println(filterName);
        //根据name获取value
        String username = filterConfig.getInitParameter("username");
        System.out.println(username);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter_test01执行了...");

        //处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //放行
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("对象销毁了...");
    }
}
