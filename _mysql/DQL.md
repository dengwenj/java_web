## DQL
* DQL 英文全称是 Data Query Language(数据查询语言)，用来查询数据库表中的记录
* 关键字：SELECT

## 语法
* select   字段列表
* from     表名列表
* where    条件列表
* group by 分组字段列表
* having   分组后条件列表
* order by 排序字段列表
* limit    分页参数

## 基本查询
* 语法：
* 查询多个字段：select 字段1,字段2,字段3 from 表名;
* 查询所有字段(通配符)：select * from 表名;
* 设置别名：select 字段1【as 别名1】,字段2【as 别名2】from 表名; （可以不用写 as）
* 去重重复记录：select distinct 字段列表 from 表名;
```mysql
# 基本查询
# 查询多个字段
select username, name from tb_emp;

# 查询所有字段
select * from tb_emp;

# 设置别名
select username as un, name as n from tb_emp;

# 设置别名可以不写 as
select username 用户名, name '姓 名' from tb_emp;

# 去重重复记录
select distinct job from tb_emp;
```

## 注意事项
* *号代表查询所有字段，在实际开发中尽量少用（不直观，影响效率）