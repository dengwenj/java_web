## 简单参数
* SpringBoot 方式
* 简单参数：
* 1、参数名与形参变量名相同，定义形参即可接收参数
* 2、如果方法形参名称与请求参数名称不匹配，可以使用 @RequestParam 完成映射
* @RequestParam(name = "age")
* @RequestParam 中的 required 属性默认为 true，代表该请求参数必须传递，如果不传递将报错。如果该参数是可选的，可以将required属性设置为 false

## 简单参数总结
* 1、原始方式获取请求参数：
* Controller 方法形参中声明 HttpServletRequest 对象
* 调用对象的 getParameter(参数名)
* 2、SpringBoot 中接收简单参数
* 请求参数名与方法形参变量名相同
* 会自动进行类型转换
* 3、@RequestParam 注解
* 方法形参名称与请求参数名称不匹配，通过该注解完成映射
* 该注解的 required 属性默认是 true，代表请求参数必须传递
```java
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
```

## 实体参数
* 简答实体对象：请求参数名与形参对象属性名相同，定义 POJO 接收即可
```java
@RestController
public class RequestController {
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
}
```

## 数组集合参数
* 数组：请求参数名与形参中数组变量名相同，可以直接使用数组封装
* 集合：请求参数名与形参中集合变量名相同，通过 @RequestParam 绑定参数关系
```java
public class RequestController {
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
``` 