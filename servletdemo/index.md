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
