## DDL
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
