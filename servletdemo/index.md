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

### Servlet
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
* Tomcat 作为Servlet容器,负责处理客户请求,把请求传送给Servlet,并将Servlet的响应传送回给客户。

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

### GenericServlet 抽象类
* GenericServlet 使编写 Servlet 变得更容易，它提供生命周期方法 init 和 destroy 的简单实现，
* 要编写一般的 Servlet，只需重写抽象 service 方法即可

### HttpServlet 类
* HttpServlet 是继承 GenericServlet 的基础上进一步的扩展
* 提供将要被子类化以创建适用于 Web 站点的 HTTP servlet 的抽象类。HttpServlet 的子类至少必须重写一个方法，该方法通常是以下这些方法之一：
* doGet，如果 servlet 支持 HTTP get 请求
* doPost，用于 HTTP POST 请求
* doPut，用于 HTTP PUT 请求
* doDelete，用于 HTTP DELETE 请求