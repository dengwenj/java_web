package vip.dengwj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

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

    // 实体参数：请求参数和形参对象属性名相同即可
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "OK";
    }

    // 复杂实体参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user); // User{name=pm, age=24, address=Address{province = 上海, city = 上海}}
        return "OK";
    }

    // 数组参数
    @RequestMapping("/arrayParams")
    public String arrayParams(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    // 集合参数
    @RequestMapping("/listParams")
    public String listParams(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }
}
