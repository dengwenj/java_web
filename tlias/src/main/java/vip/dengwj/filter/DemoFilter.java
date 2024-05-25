package vip.dengwj.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    // 初始化方法，web 服务器启动，创建 Filter 时调用，只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法，web 服务器启动，创建 Filter 时调用，只调用一次");
    }

    // 拦截到请求时，调用该方法，可调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我拦截下来了，做了一些事情，放行前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行后");
    }

    // 销毁方法，服务器关闭时调用，只调用一次
    @Override
    public void destroy() {
        System.out.println("销毁方法，服务器关闭时调用，只调用一次");
    }
}
