package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class SessionController {
    @GetMapping("/c1")
    public Result setCookie(HttpServletResponse response) {
        response.addCookie(new Cookie("pumu", "朴睦"));
        return Result.success();
    }

    @GetMapping("/c2")
    public Result getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("cookie.getName() = " + cookie.getName());
                System.out.println("cookie.getValue() = " + cookie.getValue());
            }
        }
        return Result.success();
    }
}
