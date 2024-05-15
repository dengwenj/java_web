package vip.dengwj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RequestController {
    // HttpServletRequest 原始形式
//    @RequestMapping("/getParams")
//    public String getParams(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        System.out.println(name);
//        System.out.println(Integer.parseInt(ageStr));
//        return "OK";
//    }

    // springboot 形式的简单参数
//    @RequestMapping("/getParams")
//    public String getParams(String name, int age) {
//        System.out.println(name + age);
//        return "OK";
//    }

    @RequestMapping("/getParams")
    public String getParams(@RequestParam(name = "name", required = false) String username, int age) {
        System.out.println(username + age);
        return "OK";
    }
}
