package vip.dengwj.servletdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/filter1")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter end");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
