package vip.dengwj.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 session
        HttpSession session = req.getSession();
        System.out.println(session.getId());

        session.setAttribute("username", "李雷");
        Object username = session.getAttribute("username");
        System.out.println(username);
        session.removeAttribute("username");
        Object username1 = session.getAttribute("username");
        System.out.println(username1);

        //设置最大有效事件（单位：秒）
        session.setMaxInactiveInterval(3600);
        // 立即失效
        session.invalidate();
    }
}
