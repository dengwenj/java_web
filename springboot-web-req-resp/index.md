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

## 日期时间参数
* 请求参数名与形参中数组变量名相同，通过 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 绑定关系
```java
@RestController
public class RequestController {
    // 日期参数
    @RequestMapping("/dateParams")
    public String dateParams(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        String format = updateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format); // 2024-05-16 16:10:00
        return "OK";
    }
}
```

## json 参数
* json 数据键名和形参对象属性名相同，定义 POJO 类型形参即可接收参数，需要使用 @RequestBody 标识
```java
@RestController
public class RequestController {
    // User 实体类
    // json 参数 必须要加上 @RequestBody 注解
    @RequestMapping("/jsonParams")
    public String jsonParams(@RequestBody User user) {
        System.out.println(user); // User{name='朴睦', age=24, address=Address{province = 上海, city = 上海}}
        return "OK";
    }
}
```

## 路径参数
* 通过请求 URL 直接传递参数，使用 {...} 来标识该路径参数，需要使用 @PathVariable 获取路径参数
```java
@RestController
public class RequestController {
    // 路径参数
    @RequestMapping("/pathParams/{id}/{name}") // id 需要和下面的形参名一致
    public String pathParams(@PathVariable String id, @PathVariable String name) {
        System.out.println(id + name);
        return "OK";
    }
}
```

## 响应数据 @ResponseBody
* 类型：方法注解、类注解
* 位置：Controller 方法上/类上
* 作用：将方法返回值直接响应，如果返回值类型是实体对象/集合，将会转换成 json 格式响应
* 说明：@RestController = @Controller + @ResponseBody

## 统一响应结果
```java
package vip.dengwj.pojo;

/**
 * 统一响应结果
 */
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    // 静态方法，封装多一点，不用写那么多
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result success() {
        return new Result(1, "success", null);
    }

    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    public String toString() {
        return "Result{code = " + code + ", msg = " + msg + ", data = " + data + "}";
    }
}
```

## 三层架构
* controller -> service -> dao
* controller <- service <- dao
* controller：控制层，接收前端发送的请求，对请求进行处理，并响应数据。（接收请求、响应数据）
* service：业务逻辑层，处理具体的业务逻辑。（逻辑处理）
* dao：数据访问层（Data Access Object）（持久层），负责数据访问操作，包括数据的增、删、改、查。（数据访问）

## 分层解耦
* 内聚：软件中各个功能模块内部的功能联系
* 耦合：衡量软件中各个层/模块之间的依赖、关联的程度
* 软件设计原则：高内聚低耦合
* 
* 控制反转：Inversion Of Control，简称 IOC。对象的创建控制权由程序自身转移到外部(容器)，这种思想称为控制反转
* 依赖注入：Dependency Injection，简称 DI。容器为应用程序提供运行时，所依赖的资源，称为依赖注入
* Bean 对象：IOC 容器中创建、管理的对象，称之为bean

## IOC & DI 入门
* 1、Service 层及 Dao 层的实现类，交给 IOC 容器管理。@Component
* 2、为 Controller 及 Service 注入运行时，依赖的对象 @Autowired
* @Component // 将当前类交给 IOC 容器管理，成为 IOC 容器中的 bean
* @Autowired // 运行时，IOC 容器会提供该类型的 bean 对象，并赋值给该变量 - 依赖注入

## Bean 对象的声明
* 要把某个对象交给 IOC 容器管理，需要再对应的类上加上如下注解之一：
* @Component：声明 bean 的基础注解，不属于以下三类时，用次注解（例如：工具类）
* @Controller：@Component 的衍生注解，标注在控制器类上
* @Service：@Component 的衍生注解，标注在业务类上
* @Repository：@Component 的衍生注解，标注在数据访问类上（由于与 mybatis 整合，用的少）
* 注意事项：
* 1、声明 bean 的时候，可以通过 value 属性指定 bean 的名字，如果没有指定，默认为类名首字母小写
* 2、使用以上四个注解都可以声明 bean，但是在 springboot 集成 web 开发中，声明控制器 bean 只能用 @Controller

## Bean 组件扫描
* 前面声明 bean 的四大注解，想要生效，还需要被组件扫描注解 @ComponentsScan 扫描
* @ComponentScan 注解虽然没有显示配置，但是实际上已经包含在了启动类声明注解 @SpringBootApplication 中，默认扫描的范围是启动类所在包及其子包
