package vip.dengwj.servletdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/test")
//@WebFilter("*.html")
@WebFilter("/*")
public class MatchFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截所有");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("end");
    }
}
