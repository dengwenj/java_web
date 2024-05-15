## Spring
* Spring 是一个开源的java平台，提供了一种全面的编程和配置模型，用于构建企业级应用程序
* Spring 提供了若干个子项目，每个项目用于完成特定的功能

## SpringBoot
* SpringBoot 是 Spring 下的一个子项目，可以帮助我们非常快速的构建应用程序、简化开发、提高效率

## HTTP
* Hyper Text Transfer Protocol，超文本传输协议，规定了浏览器和服务器之间数据传输的规则
* 特点：
* 1、基于 TCP 协议：面向连接，安全
* 2、基于请求-响应模型的：一次请求对应一次响应
* 3、HTTP 协议是无状态的协议：对于事物处理没有记忆能力。每次请求-响应都是独立的
* 缺点：多次请求间不能共享数据
* 有点：速度快

## WEB 服务器
* Web 服务器是一个软件程序，对 HTTP 协议的操作进行封装，使得程序员不比直接对协议进行操作，让 Web 开发更加便捷。主要功能是提供网上信息浏览服务

## Tomcat
* Tomcat 是 Apache 软件基金会一个核心项目，是一个开源免费的轻量级 Web 服务器，支持 Servlet/JSP 少量 javaEE 规范
* javaEE：java Enterprise Edition，java 企业版。指 java 企业级开发的技术规范总和。包含13项技术规范：JDBC、JNDI、EJB、RMI、JSP、Servlet、XML、JMS、Java IDL、JTS、JTA、JavaMail、JAF
* Tomcat 也被称为 Web 容器、Servlet 容器。Servlet 程序需要依赖于 Tomcat 才能运行
* JavaSE：java标准版、JavaME：java小型版、JavaEE：java企业版

## Tomcat 基本使用
* 安装、卸载、启动：sudo sh ./startup.sh、停止：sh ./shutdown.sh、部署：应用复制到 webapps 目录

## SpringBootWeb-入门程序解析
* 起步依赖：
* 1、spring-boot-starter-web：包含了 web 应用开发所需要的常见依赖（maven 的依赖传递）
* 2、spring-boot-starter-test：包含了单元测试所需要的常见依赖
* Springboot 之所以可以启动 web 服务器，是因为它内嵌了 tomcat