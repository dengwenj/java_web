## 文件上传
* 文件上传，是指将本地图片、视频、音频等文件上传到服务器，供其他用户浏览或下载的过程。
* Springboot 文件上传用 MultipartFile 形参类型
```java
public class UploadController {
    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public Result upload(String name, String password, MultipartFile file) {
      log.info("文件上传：{}, {}, {}", name, password, file);

      return Result.success();
    }
}
```

## 本地存储
* 在服务端，接收到上传上来的文件之后，将文件存储在本地服务器磁盘中
* 在 Springboot 中，文件上传，默认单个文件允许最大大小为 1M，如果需要上传大文件，可以进行如下配置：
* 配置单个文件最大上传大小：spring.servlet.multipart.max-file-size=10MB
* 配置单个请求最大上传大小（一次请求可以上传多个文件）：spring.servlet.multipart.max-request-size=100MB
* MultipartFile 对象的方法：
* 获取原始文件名：String getOrigininalFilename()
* 将接收的文件转存到磁盘文件中：void transferTo(File dest)
* 获取文件的大小，单位：字节：long getSize()
* 获取文件内容的字节数组：byte[] getBytes()
* 获取接收到的文件内容的输入流：InputStream getInputStream()

## 本地存储缺点
* 无法直接访问，磁盘满了，磁盘坏了

## 配置格式
* Springboot 提供了多种属性配置方式：
* 1、application.properties
* 2、application.yml
* 3、application.yaml

## yml 基本语法
* 大小写敏感
* 数值前边必须有空格，作为分隔符
* 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可
* #表示注释
* server:
*   port: 8080
*   address: 127.0.0.1

## yml 数据格式
* 对象/Map集合：
* user:
*   name: zhangsan
*   age: 18
* 
* 数组/List/Set集合：
* hobby:
*  -空格java
*  -空格c

## @ConfigurationProperties 与 @Value
* 相同点：都是用来注入外部配置的属性的
* 不同点：
* 1、@Value 注解只能一个一个的进行外部属性的注入
* 2、@ConfigurationProperties 可以批量的将外部的属性配置注入到 bean 对象的属性中

## 会话技术
* 会话：用户打开浏览器，访问 web 服务器的资源，会话建立，直到有一方断开连接，会话结束。在一次会话中可以包含多次请求和响应
* 会话跟踪：一种维护浏览器状态的方法，服务器需要识别多次请求是否来自于同一浏览器，以便在同一次会话的多次请求间**共享数据**
* 会话跟踪方案：
* 1、客户端会话跟踪技术：Cookie
* 2、服务端会话跟踪技术：Session
* 3、令牌技术

## Cookie
* 优点：HTTP 协议中支持的技术
* 缺点：
* 1、移动端 APP 无法使用 Cookie
* 2、不安全、用户可以自己禁用 Cookie
* 3、Cookie 不能跨域

## Session
* 优点：存储在服务端，安全
* 缺点：服务器集群环境下无法直接使用 Session，Cookie 的缺点

## 令牌技术
* 优点：
* 1、支持 PC 端，移动端
* 2、解决集群环境下的认证问题
* 3、减轻服务器端存储压力
* 缺点：需要自己实现

## JWT
* 全称：JSON Web Token
* 定义了一种简洁的、自包含的格式，用于在通信双方以 json 数据格式安全的传输信息。由于数字签名的存在，这些信息是可靠的
* 组成：
* 1、Header(头)，记录令牌类型、签名算法等。例如: {"id": "1", "username": "Tom"}
* 2、Payload(有效载荷)，携带一些自定义信息、默认信息等。例如：{"id": "1", "username": "Tom"}
* 3、Signature(签名)，防止 Token 被篡改、确保安全性。将 header、payload，并加入指定秘钥，通过指定签名算法计算而来
* Base64：是一种基于 64 个可打印字符(A-Z a-z 0-9 + /) 来表示二进制数据的编码方式
```java
public void gJWT() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "朴睦");

        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, "pumuww") // 签名算法，pumuww(秘钥)
            .setClaims(map) // 自定义载荷
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 一小时
            .compact();
        parseJWT(jwt);// eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5py0552mIiwiaWQiOjEsImV4cCI6MTcxNjYzNDc4Nn0.5cFjPofoPDMozk2mppFS9JaypPMJi3Zenrc4d4ePytU
    }

    /**
     * 解析 JWT 令牌
     */
    public void parseJWT(String jwt) {
        Claims data = Jwts.parser()
            .setSigningKey("pumuww") // 秘钥
            .parseClaimsJws(jwt)
            .getBody();
        System.out.println(data + "ww");
    }
```

## 注意事项
* JWT 校验时使用的签名秘钥，必须和生成 JWT 令牌时使用的秘钥是配套的
* 如果 JWT 令牌解析校验时报错，则说明 JWT 令牌被篡改或失效了，令牌非法

## 过滤器（Filter）
* 概念：Filter 过滤器，是 javaweb 三大组件(Servlet、Filter、Listener)之一
* 过滤器可以把对资源的请求拦截下来，从而实现一些特殊的功能
* 过滤器一般完成一些通用的操作，比如：登录验证、统一编码处理、敏感字符处理
* 定义 Filter：定义一个类，实现 Filter 接口，并重写其所有方法
* 配置 Filter：Filter 类上加 @WebFilter 注解，配置拦截资源的路径。引导类上加 @ServletComponentScan 开启 Servlet 组件支持

## Filter 执行流程
* 放行后访问对应资源，资源访问完成后，还会回到 Filter 中吗？ 会
* 如果回到 Filter 中，是重新执行还是执行放行后的逻辑呢？ 执行放行后的逻辑
* 请求 -> 放行前逻辑 -> 放行 -> 资源 -> 放行后逻辑

## Filter 拦截路径
* Filter 可以根据需求，配置不同的拦截资源路径：
* /login：只访问 /login 路径时，才会被拦截
* /emps/*：访问 /emps 下的所有资源，都会被拦截
* /*：访问所有资源，都会被拦截

## Filter 过滤器链（就是可以有多个中间件）
* 介绍：一个 web 应用中，可以配置多个过滤器，这多个过滤器就形成了一个过滤器链
* 顺序：注解配置的 Filter，优先级是按照过滤器类名(字符串)的自然排序

## 拦截器（Interceptor）
* 概念：是一种动态拦截方法调用的机制，类似于过滤器。Spring 框架中提供的，用来动态拦截控制器方法的执行
* 作用：拦截请求，在指定的方法调用前后，根据业务需要执行预先设定的代码
* 定义拦截器，实现 HandlerInterceptor 接口，并重写其所有方法
* 注册配置拦截器

## 拦截器 Interceptor 拦截路径
* 拦截器可以根据需求，配置不同的拦截路径：
* addPathPatterns 需要拦截那些 excludePathPatterns 不需要拦截那些
* /*：一级路径，能匹配 /depts，/emps，/login，不能匹配 /depts/1
* /**：任意级路径，都能匹配
* /depts/*：/depts 下的一级路径，能匹配 /depts/1，不能匹配 /depts/1/2，/depts
* /depts/**：/depts 下的任意级路径，能匹配 /depts，/depts/1，/depts/1/2，不能匹配 /emps/1

## 拦截器-执行流程
* Filter 在 Interceptor 的前面执行
* Filter 和 Interceptor：
* 接口规范不同：过滤器需要实现 Filter 接口，而拦截器需要实现 HandlerInterceptor 接口
* 拦截范围不同：过滤器 Filter 会拦截所有的资源，而 Interceptor 只会拦截 Spring 环境中的资源

## 异常处理
* 方案1：在 Controller 的方法中进行 try...catch 处理，不推荐
* 方案2：全局异常处理器, 推荐
```java
package vip.dengwj.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.dengwj.pojo.Result;

/**
 * 全局异常处理器
 * Spring 里面的，没捕获的所有错误都会到这里来
 */
@RestControllerAdvice
// @RestControllerAdvice = @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
    // Exception.class 捕获所有异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}
```