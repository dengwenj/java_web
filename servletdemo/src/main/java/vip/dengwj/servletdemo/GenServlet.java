package vip.dengwj.servletdemo;

import javax.servlet.*;
import java.io.IOException;

// 可以不跟 http 协议关联的 Servlet，其他协议也行
public class GenServlet extends GenericServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("GenServlet init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet");
    }
}
