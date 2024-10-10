package vip.dengwj.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/r")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 对 request 请求对象设置统一的编码
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username post:" + username);
        System.out.println("password post:" + password);

        // 响应
        // 服务端设置的编码格式，防止乱码
        //resp.setCharacterEncoding("UTF-8");
        // 传递给客户端的编码格式，让客户端知道
        //resp.setHeader("Content-type", "text/html;charset=UTF-8");
        // 上面的可见简化成这样
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("注册成功！");
    }
}
