## 什么是数据库？
* 数据库：DataBase（DB），是存储和管理数据的仓库
* 数据库管理系统：DataBase Management System（DBMS），操作和管理数据库的大型软件
* SQL：Structured Query Language，操作关系型数据库的编程语言，定义了一套操作关系型数据库统一标准

## 数据库设计
* 多表设计

## 数据库操作
* 数据库操作-DML
* 数据库操作-DQL
* 事务
* 多表查询

## 数据库优化
* 索引

## MySQL 数据模型
* 关系型数据库（RDBMS）：建立在关系模型基础上，由多张相互连接的二维表组成的数据库
* 特点：
* 1、使用表存储数据，格式统一，便于维护
* 2、使用 SQL 语言操作，标准统一，使用方便，可用于复杂查询
* MySQL 数据库中存储数据需要先去创建数据库，然后在这个数据库下再去创建对应的表结构，然后再将数据存放在这个表结构当中，
* 一个数据库服务器当中可以创建多个数据库，多个数据库之间是相互独立的，数据库下可以创建多张表，表里可以存放多条数据，这就是 MySQL 数据模型

## SQL 简介
* SQL：一门操作关系型数据库的编程语言，定义操作所有关系型数据库的统一标准
* 通用语法：
* SQL 语句可以单行或多行书写，以分号结尾
* SQL 语句可以使用空格/缩进来增强语句的可读性
* MySQL 数据库的 SQL 语句不区分大小写
* 注释：单行注释 -- 注释内容 或 # 注释内容(MySQL 特有)、多行注释：/* 注释内容 */

## SQL 分类
* SQL 语句通常被分为四大类：
* DDL：Data Definition Language，数据定义语言，用来定义数据库对象(数据库、表、字段)
* DML：Data Manipulation Language，数据操作语言，用来对数据库表中的数据进行增删改
* DQL：Data Query Language，数据查询语言，用来查询数据库中表的记录
* DCL：Data Control Language，数据控制语言，用来创建数据库用户、控制数据库的访问权限

## DDL（数据库操作）
* 1、查询：
* 查询所有数据库：show databases;
* 查询当前使用的数据空：select data();
* 2、创建：
* 创建数据库：create database 【if not exists】数据库名;
* 3、使用：
* 使用数据库：use 数据库名;
* 4、删除：
* 删除数据库：drop database【if exists】数据库名;
* 注意事项：上述语法中的 database，也可以替换成 schema，如：create schema db01;

## 创建表结构基本语法
* create table 表名(
*   字段1 字段类型 【约束】【comment 字段1注释】,
*   字段n 字段类型 【约束】【comment 字段n注释】,
* )【comment 表注释】;

## 约束
* 概念：约束是作用于表中字段上的规则，用于限制存储在表中的数据
* 目的：保证数据库中数据的正确性、有效性和完整性
* 
* 非空约束：限制该字段值不能为 null。not null
* 唯一约束：保证字段的所有数据都是唯一，不重复的。unique
* 主键约束：主键是一行数据的唯一标识，要求非空且唯一。primary key (auto_increment 自增)
* 默认约束：保存数据时，如果未指定该字段值，则采用默认值。default
* 外键约束：让两张表的数据建立连接，保证数据的一致性和完整性。foreign key
```mysql
# 创建表
create table tb_user (
    id int primary key auto_increment comment 'id，唯一标识',
    username varchar(20) not null unique comment '用户名',
    name varchar(10) not null comment '名称',
    age int comment '年龄',
    gender char default '男' comment '性别'
) comment '用户表';
```
