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

## DQL 条件查询
* 语法：
* 条件查询：select 字段列表 from 表名 where 条件列表;

## 比较运算符
* 1、> 大于，>= 大于等于，< 小于，<= 小于等于，= 等于，<> 或 != 不等于
* 2、between ... and ...： 在某个范围之内(含最小、最大值)
* 3、in(...)： 在 in 之后的列表中的值，多选一
* 4、like 占位符： 模糊匹配(_匹配单个字符，%匹配任意个字符可以是0个字符)
* 5、is null： 是 null

## 逻辑运算符
* and 或 &&：并且(多个条件同时成立)
* or 或 ||：或者(多个条件任意一个成立)
* not 或 !：非，不是
```mysql
# 条件查询
# 1、查询姓名为 朴睦 的员工
select *
from tb_emp
where name = '朴睦';

# 2、查询 id 小于等于 5 的员工信息
select *
from tb_emp
where id <= 5;

# 3、查询没有分配职位的员工信息
select id,
       username,
       name,
       password,
       gender,
       image,
       job,
       entry_date,
       create_time,
       update_time
from tb_emp
where job is null;

# 4、查询有职位的员工信息
select *
from tb_emp
where job is not null;

# 5、查询入职日期在 '2000-01-01' 到 '2008-12-31' 之间的员工信息
select *
from tb_emp
where entry_date >= '2000-01-01'
  and entry_date <= '2008-12-31';

select *
from tb_emp
where entry_date between '2000-01-01' and '2008-12-31';

# 6、查询密码不等于 '123456' 的员工信息
select *
from tb_emp
where password != '123456';

# 7、查询入职日期在 2000-01-01 到 2008-12-31 之间 且 性别为 女 的员工信息
select *
from tb_emp
where (entry_date between '2000-01-01' and '2008-12-31')
  and gender = 2;

# 8、查询职位是 2，3，4的员工信息
select * from tb_emp where job = 2 or job = 3 or job = 4;

select *
from tb_emp
where job in(2, 3, 4); -- 多选一 符合2或3或4的

# 9、查询姓名为两个字的员工信息
select *
from tb_emp
where name like '__'; -- _匹配单个字符

# 10、查询姓 苏 的员工信息
select *
from tb_emp
where name like '苏%' -- %匹配任意个字符可以是0个字符
```

## 聚合函数
* 介绍：将一列数据作为一个整体，进行纵向计算
* 语法：select 聚合函数(字段列表) from 表名;
```mysql
# 聚合函数
# 1、统计该企业员工数量
# 按字段
select count(name) from tb_emp;
select count(job) from tb_emp; -- 不对 null 值进行计算
# 按常量
select count(1) from tb_emp;
# *
select count(*) from tb_emp;

# 2、统计该企业最早入职的员工
select min(entry_date) from tb_emp;

# 3、统计该企业最迟入职的员工
select max(entry_date) from tb_emp;

# 4、统计该企业员工 ID 的平均值
select avg(id) from tb_emp;

# 5、统计该企业员工的 ID 之和
select sum(id) from tb_emp;
```

## 函数
* count：统计数量
* max：最大值
* min：最小值
* avg：平均值
* sum：求和

## 注意事项
* null 值不参与所有聚合函数运算
* 统计数量可以使用：count(*)、count(字段)、count(常量), 推荐使用 count(*)

## DQL-分组查询
* 分组查询：select 字段列表 from 表名 【where 条件】group by 分组字段名 【having 分组后过滤条件】;
```mysql
# 分组
# 1、根据性别分组，统计男性和女性员工的数量
select gender, count(*)
from tb_emp
group by gender;

# 2、先查询入职时间在 '2010-01-01' 以后的员工，并对结果根据职位分组，获取员工数量大于等于 2 的职位
select job, count(*)
from tb_emp
where entry_date >= '2010-01-01'
group by job
having count(*) >= 2;
```

## where 与 having 区别
* 1、执行时机不同：where 是分组之前进行过滤，不满足 where 条件，不参与分组，而 having 是分组之后对结果进行过滤
* 2、判断条件不同：where 不能对聚合函数进行判断，而 having 可以

## 注意事项
* 分组之后，查询的字段一般为聚合函数和分组字段，查询其他字段无任何意义
* 执行顺序：where > 聚合函数 > having

## 排序查询
* 条件查询：select 字段列表 from 表名【where 条件列表】【group by 分组字段】order by 字段1 排序方式1, 字段2 排序方式2...;
```mysql
# 排序查询
# 1、根据入职日期，对员工进行升序排序
select * from tb_emp order by entry_date asc;
select * from tb_emp order by entry_date;

# 2、根据入职时间，对员工进行降序排序
select * from tb_emp order by entry_date desc;

# 3、根据入职时间对公司的员工进行升序排序，入职时间相同，在按照更新时间进行降序排序
select * from tb_emp order by entry_date, update_time desc;
```

## 排序方式
* ASC: 升序(默认值)
* DESC：降序

## 注意事项
* 如果是多字段排序，当第一个字段值相同时，才会根据第二个字段进行排序