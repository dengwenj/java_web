## MyBatis
* MyBatis 是一款优秀的持久层框架，用于简化 JDBC 的开发
* MyBatis 本是 Apache 的一个开源项目 iBatis，2010 年这个项目由 apache 迁移到了 google code，并且改名为  MyBatis，2013年11月迁移到 GitHub

## 步骤
* 1、准备工作(创建 springboot 工程、数据库表 user、实体类 User)。Java实体类：通常与关系型数据库中的表对应，主要用于表示和存储真实世界中的对象。
* 2、引入 MyBatis 的相关依赖，配置 MyBatis（数据库连接信息）
* 3、编写 SQL 语句(注解/XML)