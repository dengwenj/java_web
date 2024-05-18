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