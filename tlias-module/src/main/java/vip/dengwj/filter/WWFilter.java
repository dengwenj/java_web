package vip.dengwj.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class WWFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器链前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器链后");
    }
}
