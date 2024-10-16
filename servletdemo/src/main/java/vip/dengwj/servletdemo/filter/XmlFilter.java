package vip.dengwj.servletdemo.filter;

import javax.servlet.*;
import java.io.IOException;

public class XmlFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("XmlFilter start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("XmlFilter end");
    }
}
