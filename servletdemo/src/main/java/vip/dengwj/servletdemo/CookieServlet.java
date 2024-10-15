package vip.dengwj.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", URLEncoder.encode("朴睦", "UTF-8"));
        Cookie cookie1 = new Cookie("password", "123456");
        // 设置 Cookie 的路径
        cookie.setPath("/webproject/get1");
        cookie1.setPath("/webproject");
        // 设置 Cookie 的过期时间
        cookie.setMaxAge(3600);
        cookie1.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }
}
