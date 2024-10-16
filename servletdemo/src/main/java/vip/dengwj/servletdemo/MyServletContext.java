package vip.dengwj.servletdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/servletContext")
public class MyServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        HttpSession session = req.getSession();
        ServletContext servletContext2 = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(servletContext1);
        System.out.println(servletContext2);

        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath); // /webproject
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath); // /Users/dengwenjie/Java/apache-tomcat-9.0.96/webapps/webproject/
        servletContext.setAttribute("username", "朴睦");
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }
}
