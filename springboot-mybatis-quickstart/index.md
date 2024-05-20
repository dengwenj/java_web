## MyBatis
* MyBatis 是一款优秀的持久层框架，用于简化 JDBC 的开发(封装了 JDBC)
* MyBatis 本是 Apache 的一个开源项目 iBatis，2010 年这个项目由 apache 迁移到了 google code，并且改名为  MyBatis，2013年11月迁移到 GitHub

## 步骤
* 1、准备工作(创建 springboot 工程、数据库表 user、实体类 User)。
* Java实体类：通常与关系型数据库中的表对应，主要用于表示和存储真实世界中的对象。pojo 文件夹存放实体的类
* 2、引入 MyBatis 的相关依赖，配置 MyBatis（数据库连接信息）
* 3、编写 SQL 语句(注解/XML)

## JDBC
* JDBC：Java DataBase Connectivity，就是使用 java 语言操作关系型数据库的一套 API
* 本质：
* 1、sun 公司官方定义的一套操作所有关系型数据库的规范，即接口
* 各个数据库厂商去实现这套接口，提供数据库驱动(mysql 实现) jar 包
* 我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动 jar 包中的实现类

## 数据库连接池
* 数据库连接池是一个容器，负责分配、管理数据库连接(Connection)
* 它允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个
* 释放空闲时间超过最大空闲时间的连接，来避免因为没有释放连接而引起的数据库连接遗漏
* 标准接口：DataSource
* 官方提供的数据库连接池接口，由第三方组织实现此接口
* 功能：获取连接 Connection getConnection() throws SQLException;

## 优势
* 资源重用
* 提升系统响应速度
* 避免数据库连接遗漏

## 常见产品
* C3P0、DBCP、Druid(阿里巴巴)、Hikari(springboot 默认)