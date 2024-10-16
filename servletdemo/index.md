### 什么是 web
* web(world wide web) 称为万维网，简单理解就是网站，它用来表示 Internet 主机上供外界访问的资源
* Internet 上供外界访问的资源分为两类：
* 1、静态资源：指 web 页面中供人们浏览的数据始终是不变的（html css）
* 2、动态资源：指 web 页面中供人们浏览的数据是由程序产生的，不同时间点，甚至不同设备访问 web 页面看到的内容各不相同
* 在 java 中，动态 web 资源开发技术我们统称为 java web

### 什么是 web 服务器（软件、工具）
* web 服务器是运行及发布 web 应用的容器，只有将开发的 web 项目放置该容器中，才能使网络中的所有用户通过浏览器进行访问
* web 服务器要跑在一台服务器上(startup.sh)，这样就可以通过服务器 ip 地址 + web服务器端口，在浏览器中访问

### 常见的 web 服务器
* 开源：Tomcat、jetty、resin
* 收费：webLogic、WebSphere

### Tomcat
* Tomcat 是 Apache 软件基金会的 jakarta 项目中的一个核心项目，免费开源、并支持 Servlet 和 JSP 规范
* 启动关闭 web 服务器： 打开终端，输入：cd /Users/xxxx/xxxx/apache-tomcat-x.x.xx/bin    开启 sudo sh startup.sh   关闭 sudo sh shutdown.sh
* conf 里 server.xml 修改端口
* 
* 从http协议中的请求和响应可以得知，浏览器发出的请求是一个请求文本，而浏览器接收到的也应该是一个响应文本。
  但是并不知道是如何转变的，只知道浏览器发送过来的请求也就是request，我们响应回去的就用response。
  ①：Tomcat将http请求文本接收并解析，然后封装成HttpServletRequest类型的request对象，
  所有的HTTP头数据读可以通过request对象调用对应的方法查询到。
  ②：Tomcat同时会要响应的信息封装为HttpServletResponse类型的response对象，
  通过设置response属性就可以控制要输出到浏览器的内容，然后将response交给tomcat，tomcat就会将其变成响应文本的格式发送给浏览器

### 项目部署及访问静态资源
* Tomcat 是 web 服务器，我们的项目应用是部署在 webapps 下，然后通过特定的 url 访问
* 创建项目，在 webapps 中创建文件夹
* 访问：http://localhost:7070/demo

### Servlet（服务器小程序）
* Servlet：Server Applet 的简称，是服务器端的程序（代码、功能实现），可交互式的处理客户端发送到服务端的请求，并完成操作响应
* Servlet 是一种服务器端的‌Java应用程序，具有独立于平台和协议的特性，可以生成动态的Web页面‌
* Servlet 是 JavaEE 规范之一。规范就是接口
* Servlet 是 JavaWeb 三大组件之一。三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器。
* Servlet 是运行在服务器上的一个 java 小程序，它可以接收客户端发送过来的请求，并响应数据给客户端。
* Servlet 不能独立运行，它的运行完全由Servlet引擎（容器（服务器 tomcat））控制。

### Servlet 作用
* 接收客户端请求，完成操作
* 动态生成网页（页面数据可变）
* 将包含操作结果的动态网页响应给客户端
* 用来接收、处理客户端请求、响应给浏览器的动态资源
* 但servlet的实质就是java代码，通过java的API动态的向客户端输出内容

### Servlet 工作原理
* 客户端请求Servlet‌：当客户端发送请求到服务器时，服务器会查找对应的Servlet进行处理。
* 初始化Servlet‌：实例化后，调用init()方法进行初始化。
* 处理请求‌：根据请求的方法（如GET、POST等），调用相应的doGet()、doPost()等方法处理请求。
* ‌销毁Servlet‌：当服务器关闭或应用程序停止时，销毁Servlet实例。

### IDEA 部署 Web 项目
* 前面我们是在 Tomcat 的 webapps 目录新建应用程序目录，然后把静态资源和 Servlet 复制到相关目录下
* 使用 IDEA 不需要我们复制，可以通过 IDEA 集成 Tomcat 服务器，实现自动部署

### 如何导出 war 包
* 项目完成后，有时需要打成 war 方便部署。war 包可以直接放入 Tomcat 的 webapps 目录中，启动 Tomcat 后自动解压，即可访问

### 什么是 HTTP
* 超文本传输协议（文本、图片等），是互联网上应用最为广泛的一种网络协议，是一个基于请求与响应模式的、无状态的、应用层的协议，运行于 TCP 协议基础之上

### HTTP 协议特点
* 支持客户端 / 服务器模式
* 简单快速：客户端只向服务器发送请求方法和路径，服务器即可响应数据，因而通信速度很快。请求方法常用的有 GET、POST等
* 灵活：HTTP 允许传输任意类型的数据，传输的数据类型由Content-Type 标识
* 无连接：无连接指的是每次 TCP 连接只处理一个或多个请求，服务器处理完客户的请求后，即断开连接。采用这种方式可以节省传输时间
* HTTP1.0 版本是一个请求响应之后，直接就断开了。称为短连接
* HTTP1.1 版本不是响应后直接就断开，而是等几秒钟，这几秒钟之内有新的请求，那么还是通过之前的连接通道来收发消息，如果过了这几秒钟用户没有发送新的请求，就会断开连接，称为长连接
* 无状态：HTTP 协议是无状态协议，无状态指协议对于事务的处理没有记忆能力

### HTTP 协议通信流程
* 客户与服务器建立连接（三次握手）
* 客户向服务器发送请求
* 服务器接受请求，并根据请求返回相应的文件作为应答
* 客户与服务器关闭连接（四次挥手）

### HTTP1.1
* 1、在一个 TCP 连接上可以传送多个 HTTP请求和响应
* 2、多个请求和响应过程可以重叠进行
* 3、增加了更多的请求头和响应头
* 4、Connection 报头来控制时间

### HTTP 请求报文
* 由四部分组成：
* 1、请求行 请求方法/地址 URI 协议/版本
* 2、请求头
* 3、空行
* 4、请求正文

### HTTP 响应报文
* 1、状态行
* 2、响应头
* 3、空行
* 4、响应正文

### Tomcat 与 Servlet 的关系
* Tomcat 是一个 Servlet 容器，提供了运行和管理 Servlet 的环境。
* Servlet 是服务器端的 Java 程序，用于处理客户端的请求和生成动态的 Web 内容。
* 当一个 Web 应用程序中包含 Servlet 时，这个应用程序通常会被部署到 Tomcat 或类似的 Servlet 容器中。
* Tomcat 负责管理 Servlet 的生命周期、处理请求和响应等任务，使得开发人员可以专注于编写 Servlet 程序而不必关心底层的服务器管理细节。
* Tomcat 作为Servlet容器,负责处理客户请求,把请求传送给Servlet,并将Servlet的响应传送回给客户。（重要！！！！！）

### Servlet 核心接口和类
* 在 Servlet 体系结构中，除了实现 Servlet 接口，还可以通过继承 GenericServlet 或 HttpServlet 类，完成编写

### Servlet 接口
* 在 Servlet API 中最重要的是 Servlet 接口，所有 Servlet 都会直接或间接的与该接口发生联系，或是直接实现该接口，或间接继承自实现了该接口的类
* 该接口包含以下五个方法：
* init(ServletConfig config)
* ServletConfig getServletConfig()
* service(ServletRequest req, ServletResponse res)
* String getServletInfo()
* destroy()

```java
// 可以不跟 http 协议关联的 Servlet，其他协议也行
public class HelloServlet implements Servlet {
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
      
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("Hello Servlet");
  }

  @Override
  public String getServletInfo() {
    return "";
  }

  @Override
  public void destroy() {

  }
}
```

### GenericServlet 抽象类
* GenericServlet 使编写 Servlet 变得更容易，它提供生命周期方法 init 和 destroy 的简单实现，
* 要编写一般的 Servlet，只需重写抽象 service 方法即可
```java
// 可以不跟 http 协议关联的 Servlet，其他协议也行
public class GenServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet");
    }
}
```

### HttpServlet 类
* HttpServlet 是继承 GenericServlet 的基础上进一步的扩展
* 提供将要被子类化以创建适用于 Web 站点的 HTTP servlet 的抽象类。HttpServlet 的子类至少必须重写一个方法，该方法通常是以下这些方法之一：
* doGet，如果 servlet 支持 HTTP get 请求
* doPost，用于 HTTP POST 请求
* doPut，用于 HTTP PUT 请求
* doDelete，用于 HTTP DELETE 请求
```java
// 必须和 http 协议有关联的
public class MyHttpServlet extends HttpServlet {
    // 根据不同的请求方法调用不同方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是 get 请求" + req.getRequestURI());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是 post 请求" + req.getRequestURI());
    }
}
```

### Servlet 两种配置方式
### 1、web.xml 配置（Servlet2.5以前）
* url-pattern 定义匹配规则：
* 1、精确匹配： /具体的名称  只有 url 路径是具体的名称的时候才会触发 Servlet
* 2、后缀匹配： *.xxx   只要是以 xxx 结尾的就匹配触发 Servlet
* 3、通配符匹配： /*   匹配所有请求，包含服务器的所有资源
* 4、通配符匹配： /   匹配所有请求，包含服务器的所有资源，不包括.jsp

* load-on-startup
* 1、元素标记容器是否应该在 web 应用程序启动的时候就加载这个 servlet
* 2、它的值必须是一个整数，表示 servlet 被加载的先后顺序
* 3、如果该元素的值为负数或者没有设置，则容器会当 servlet 被请求时再加载
* 4、如果值为正整数或者 0 时，表示容器在应用启动时就加载并初始化这个 servlet，值越小，servlet 的优先级越高，就越先被加载。值相同时，容器就会自己选择顺序来加载

### 2、注解配置（Servlet3.0以上）
* name：Servlet 名字（可选）
* value：配置 url 路径，可以配置多个
* urlPatterns：配置 url 路径，和 value 作用一样，不能同时使用
* loadOnStartup：配置 Servlet 的创建的时机，如果是 0 或者正数启动程序时创建，如果是负数，则访问时创建，数字越小优先级越高

### HttpServletRequest 和 HttpServletResponse
```java
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
```

### 转发
* 转发的作用在服务器端，将请求发送给服务器上的其他资源，以共同完成一次请求的处理

### 页面跳转
* req.getRequestDispatcher("/b").forward(req, resp);
* 使用 forward 跳转时，是在服务器内部跳转，地址栏不发生变化，属于同一次请求
```java
@WebServlet(value = "/a")
public class AServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //req.setAttribute("username", "pumu");
    //req.getRequestDispatcher("/b").forward(req, resp);

    System.out.println("req.getContextPath()" + req.getContextPath());
    resp.sendRedirect(req.getContextPath() + "/b?username=pm");
    //resp.sendRedirect("http://www.baidu.com");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}

@WebServlet("/b")
public class BServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println(req.getAttribute("username"));
    System.out.println("BBBBBB");
    System.out.println(req.getParameter("username"));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
```

### 数据传递
* forward 表示一次请求，是在服务器内部跳转，可以共享同一次 request 作用域中的数据
* request.setAttribute(key, value)，key 为 String， value 为 Object
* request.getAttribute(key)

### 转发特点
* 转发是服务器行为
* 转发是浏览器只做了一次访问请求
* 转发浏览器地址不变
* 转发两次跳转之间传输的信息不回丢失，所以可以通过 request 进行数据的传递
* 转发只能将请求转发给同一个 web 应用中的组件

### 重定向
* 重定向作用是在客户端，客户端将请求发送给服务器后，服务器响应给客户端一个新的请求地址，客户端重新发送新请求
* response.sendRedirect("目标 URI")
* URI：统一资源标识符，用来表示服务器中定位一个资源，资源在 web项目中的路径("/xxx/xxx")
* 数据传递：resp.sendRedirect(req.getContextPath() + "/b?username=pm")，获取 req.getParameter("username")

### 重定向特点
* 重定向是客户端行为
* 重定向是浏览器做了至少两次的访问请求
* 重定向浏览器地址改变
* 重定向两次跳转之间传输的信息会丢失（request 范围）
* 重定向可以跳转到任何资源

### Servlet 生命周期
* 生命周期四个阶段
* 1、实例化：当用户第一次访问 Servlet 时，由容器调用 Servlet 的构造器创建具体的 Servlet 对象。也可以在容器启动之后立刻创建实例，使用 loadOnStartup。只执行一次
* 2、初始化：在初始化阶段，init() 方法会被调用，这个方法在 javax.servlet.Servlet 接口中定义，其中方法以一个 ServletConfig 类型的对象作为参数。只执行一次
* 3、服务：当客户端有一个请求时，容器就会将请求 ServletRequest 与响应 ServletResponse 对象传给 Servlet，以参数的形式传给 service 方法。此方法会执行多次
* 4、销毁：当 Servlet 容器停止或者重新启动都会引起销毁 Servlet 对象并调用 destroy 方法。destroy 方法执行一次

### Servlet 线程安全问题
* Servlet 在访问之后，会执行实例化操作，创建一个 Servlet 对象。而我们 Tomcat 容器可以同时多个线程并发访问同一个 Servlet，如果在方法中对成员变量做修改操作，就会有线程安全问题
* 共享的变量可以会引发线程安全问题，3种解决办法：
* 1、synchronized：将存在线程安全问题的代码放到同步代码块中
* 2、实现 SingleThreadModel 接口：servlet 实现 SingleThreadModel 接口后，每个线程都会创建 servlet 实例，这样每个客户端请求就不存在共享资源的问题，但是 servlet 响应客户端请求的效率太低，所以已淘汰
* 3、尽可能使用局部变量（推荐）

### Cookie
* 创建 Cookie
* 修改 Cookie（只需要保证 Cookie 的名和路径一致即可修改）
* 获取 Cookie
```java
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "朴睦");
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
@WebServlet("/get1")
public class Cookie2Servlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        System.out.println("cookie: " + cookie.getName() + "; value: " + cookie.getValue());
      }
    }
  }
}
```

### Cookie 编码与解码
* Cookie 默认不支持中文，只能包含 ASCII 字符，所以 Cookie 需要对 Unicode 字符进行编码，否则会出现乱码
* 编码可以使用 java.net.URLEncoder 类的 encode(String str, String encoding) 
* 解码使用 java.net.URLDecoder 类的 decode(String str, String encoding)

### Cookie 优点和缺点
* 优点：
* 1、可配置到期规则
* 2、简单性：Cookie 是一种基于文本的轻量结构，包含简单的键值对
* 3、数据持久性：Cookie 默认在过期之前是可以一直存在浏览器上的
* 缺点：
* 1、大小受到限制：大多数浏览器对 Cookie 的大小有 4k、8k 字节的限制
* 2、用户配置为禁用：有些用户禁用了浏览器设备接收 Cookie 的能力，因此限制了这一功能
* 3、潜在的安全风险：Cookie 可能会被篡改

### Session 对象
* Session 概述：Session 用于记录用户的状态，Session 指的是在一段时间内，单个客户端与 Web 服务器的一连串相关的交互过程
* 在一个 Session 中，客户可能会多次请求访问同一个资源，也有可能请求访问各种不同的服务器资源

### Session 原理
* 服务器会为每一次会话分配一个 Session 对象
* 同一个浏览器发起的多次请求，同属于一次会话（Session），关闭浏览器下次打开 Session 就不一样了
* 首次使用到 Session 时，服务器会自动创建 Session，并创建 Cookie 存储 SessionId 发送回客户端

### Session 使用
* Session 作用域：拥有存储数据的空间，作用范围是一次会话有效（同属于一次会话当中，获取的 session 是相同的，地址是一样的）
* 一次会话是使用同一个浏览器发送的多次请求。一旦浏览器关闭，则结束会话
* 可以将数据存入 Session中，在一次会话的任意位置进行获取！！！
* 可传递任何数据
* sessionId 是用来记录是不是同一次会话

### Session 与 Request 应用区别
* request 是一次请求有效，请求改变，则 request 改变
* session 是一次火花有效，浏览器改变，则 session 改变

### Session 生命周期
* 开始：第一次使用到 Session 的请求产生，则创建 Session
* 结束：
* 1、浏览器关闭，则失效
* 2、Session 超时，则失效：session.setMaxInactiveInterval(seconds); 设置最大有效事件（单位：秒）
* 3、手工销毁，则失效：session.invalidate(); 登录退出、注销

### 浏览器禁用 Cookie 解决方案
* 服务器在默认情况下，会使用 Cookie 的方式将 sessionID 发送给浏览器，如果用户禁止 Cookie，则 sessionID 不会被浏览器保存，此时服务器可以使用如 URL 重写这样的方式来发送 sessionID
* response.encodeRedirectURL(String url); 生成重写的 URL

### ServletContext 对象
* ServletContext 概述
* 1、全局对象，也拥有作用域，对应一个 Tomcat 中的 Web 应用
* 2、当 Web 服务器启动时，会为每一个 Web 应用程序创建一块共享的存储区域（ServletContext）
* 3、ServletContext 在 Web 服务器启动时创建，服务器关闭时销毁

### 获取 ServletContext 对象
* GenericServlet 提供了 getServletContext() 方法，（推荐）this.getServletContext()
* HttpServletRequest 提供了 getServletContext() 方法（推荐）
* HttpSession 提供了 getServletContext() 方法

### ServletContext 作用
* 获取当前项目在服务器发布的真实路径：servletContext.getRealPath("/")
* 获取当前项目上下文路径（应用程序名）：servletContext.getContextPath();
* 全局容器：servletContext.setAttribute("name", value)

### ServletContext 特点
* 唯一性：一个应用对应一个 servlet 上下文
* 生命周期：只要容器不关闭或者应用不卸载，servlet 上下文就一直存在

### 作用域总结
* HttpServletRequest：一次请求，请求响应之前有效
* HttpSession：一次会话开始，浏览器不关闭或不超时之前有效
* ServletContext：服务器启动开始，服务器停止之前有效

### 过滤器（Filter）
* 过滤器是处于客户端与服务器目标资源之间的一道过滤技术

### 过滤器的作用
* 执行地位在 Servlet 之前，客户端发送请求时，会先经过 Filter，再到达目标 Servlet 中，响应时，会根据执行流程再次反向执行 Filter
* 可以解决多个 Servlet 共性代码的冗余问题（例如：乱码处理、登录验证）
```java
@WebFilter("/filter1")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter end");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
```

### 过滤器配置
* 注解配置：在自定义的 Filter 类上使用注解 @WebFilter(value = "/test")
* xml 配置
```xml
<filter>
    <filter-name>xml</filter-name>
    <filter-class>vip.dengwj.servletdemo.filter.XmlFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>xml</filter-name>
    <url-pattern>/xmlfilter</url-pattern>
</filter-mapping>
```

### 关于拦截路径
* 过滤器的拦截路径通常有三种形式：
* 1、精确拦截匹配，比如：/index.html，/test
* 2、后缀拦截匹配，比如：*.html
* 3、通配符拦截匹配 /*，表示拦截所有，/aaa/bbb/ *

### 过滤器链和优先级
* 过滤器链：客户端对服务器请求之后，服务器调用 Servlet 之前会执行一组过滤器（多个过滤器），那么这组过滤器就称为一条过滤器链
* 每个过滤器实现某个特定的功能，当第一个 Filter 的 doFilter 方法被调用时，Web 服务器会创建一个代表 Filter 链的 FilterChain 对象传递给该方法，
* 在 doFilter 方法中，开发人员如果调用了 FilterChain 对象的 doFilter 方法，则 Web 服务器会检查FilterChain 对象中是否还有 filter，如果有，则调用第二个 filter，如果没有，则调用目标资源

### 过滤器优先级
* 在一个 Web 应用中，可以开发编写多个 Filter，这些 Filter 组合起来称之为一个 Filter 链
* 优先级：
* 如果为注解的话，是按照类全名称的字符串顺序决定作用顺序
* 如果 web.xml，按照 filter-mapping 注册顺序，从上往下
* web.xml 配置高于注解方式
* 如果注解和 web.xml 同时配置，会创建多个过滤器对象，造成过滤多次