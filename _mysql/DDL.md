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

## MySQL 数据类型
* MySQL 中的数据类型有很多，主要分为三类：数值类型、字符串类型、日期时间类型

## 数值类型
* 类型          大小(byte)       有符号范围         无符号范围          描述      备注
* tinyint      1               (-128, 127)       (0, 255)        小整数值
* smallint     2               (-32768, 32767)   (0, 65535)      大整数值
* mediumint    3               大整数值
* int          4               大整数值
* bigint       8               极大整数值
* float        4               单精度浮点数值      float(5, 2): 5表示整个数字长度，2表示小数位个数
* double       8               双精度浮点数值      double(5, 2):5表示整个数字长度，2表示小数位个数
* decimal      小数值(精度更高)   decimal(5, 2): 5表示整个数字长度，2表示小数位个数
* 无符号范围加上 unsigned

## 字符串类型
* char： 0-225，定长字符串 
* varchar：0-65535，变长字符串
* ...
* char(10)：最多只能存 10 个字符，不足 10 个字符，占用10个字符空间，性能高，浪费空间
* varchar(10): 最多只能存10个字符，不足10个字符，按照实际长度存储，性能低，节省空间

## 日期类型
* date：3，YYYY-MM-DD，日期值
* time：3，HH:MM:SS，时间值或持续时间
* year：1，YYYY，年份值
* datetime：8，YYYY-MM-DD HH:MM:SS，混合日期和时间值
* timestamp：4，YYYY-MM-DD HH:MM:SS 混合日期和时间值，时间戳
```mysql
create table tb_emp (
    id int primary key auto_increment comment 'id，唯一标识',
    username varchar(20) not null unique comment '用户名',
    name varchar(10) not null comment '员工姓名',
    password varchar(30) default '123456' comment '密码',
    gender tinyint unsigned not null comment '性别，1.男，2.女',
    image varchar(300) comment '图像url',
    job tinyint unsigned comment '职位，1.班主任，2.讲师，3.学工主管，4.教研主管',
    entry_date date comment '入职日期',
    create_date datetime comment '创建时间',
    update_date datetime comment '更新时间'
) comment '员工表'
```

## DDL(操作表)
* 1、查询：
* 查询当前数据库所有表：show tables;
* 查询表结构：desc 表名;
* 查询建表语句：show create table 表名;
* 2、修改：
* 添加字段：alter table 表名 add 字段名 类型(长度) 【comment 注释】【约束】;
* 修改字段类型：alter table 表名 modify 字段名 新数据类型(长度);
* 修改字段名和字段类型：alter table 表名 change 旧字段名 新字段名 类型(长度) 【comment 注释】【约束】;
* 删除字段：alter table 表名 drop column 字段名;
* 修改表名：rename table 表名 to 新表名;
* 3、删除：
* 删除表：drop table 【if exists】表名;

## 数据库设计-DDL
* 数据库：创建、查询、使用、删除
* 表结构：创建(语法、约束、数据类型、设计)、查询、修改、删除

## DML
* DML 英文全称是 Data Manipulation Language(数据操作语言)，用来对数据库表的数据记录进行增、删、该操作
* 添加数据(INSERT)
* 修改数据(UPDATE)
* 删除数据(DELETE)

## DML(INSERT)
* insert 语法：
* 指定字段添加数据：insert into 表名 (字段名1, 字段名2) values (值1, 值2);
* 全部字段添加数据：insert into 表名 values (值1, 值2, ...);
* 批量添加数据（指定字段）：insert into 表名 (字段名1, 字段名2) values (值1, 值2), (值1, 值2);
* 批量添加数据（全部字段）：insert into 表名 value (值1, 值2), (值1, 值2);

## 注意事项
* 1、插入数据时，指定的字段顺序需要与值的顺序是一一对应的
* 2、字符串和日期型数据应该包含在引号中
* 3、插入的数据大小，应该在字段的规范范围内
```mysql
# 插入数据，指定的字段
insert into tb_emp (username, name, gender, create_time, update_time)
values ('pumu', '朴睦', 1, now(), now());

# 添加全部字段数据
insert into tb_emp
values (null, 'lilei', '李雷', '123321', 1, 'l.jpg', 1, '2023-10-10', now(), now());

# 批量添加数据（指定字段）
insert into tb_emp (username, name, gender, create_time, update_time)
values ('hanmeimei', '韩梅梅', 2, now(), now()),
       ('wangxiaobo', '王小波', 1, now(), now());

# 批量添加全部数据
insert into tb_emp
values (null, 'wangyangming', '王阳明', '123456', 1, 'w.jpg', 2, '2024-01-04', now(), now()),
       (null, 'sushi', '苏轼', '000000', 1, 's.jpg', 3, '2022-04-07', now(), now());
```

## DML(UPDATE)
* update 语法：
* 修改数据：update 表名 set 字段名1 = 值1, 字段名2 = 值2,... 【where 条件】;
* 修改语句的条件可以有，也可以没有，如果没有条件，则会修改整张表的所有数据
```mysql
update tb_emp
set name = '王王',
    job  = 3
where id = 4;
```

## DML（DELETE）
* delete 语法：
* 删除数据：delete from 表名 【where 条件】;

## 注意事项
* 1、DELETE 语句的条件可以有，也可以没有，如果没有条件，则会删除整张表的所有数据
* 2、DELETE 语句不能删除某一个字段的值（如果要操作，可以使用 UPDATE，将该字段的值置为 NULL）
```mysql
# 删除表数据
delete
from tb_emp
where id = 3;

delete from tb_emp;
```