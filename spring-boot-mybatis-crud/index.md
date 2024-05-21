## Mybatis 删除
* delete from emp where id = 10;
* 接口方法：
* @Delete("delete from emp where id = #{id}")
* int deleteEmp(Integer id);
* 如果 mapper 接口方法形参只有一个普通类型的参数，#{...}里面的属性名可以随便写，如：#{id}、#{value}

## 日志输出
* 可以在 application.properties 中，打开 mybatis 的日志，并指定输出到控制台
* mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

## 预编译 SQL
* 优势：
* 1、性能更高
* 2、更安全（防止 SQL 注入）
* MySQL：SQL语法解析检查 -> 优化SQL -> 编译SQL -> 执行SQL

## SQL 注入
* SQL 注入是通过操作输入的数据来修改事先定义好的 SQL 语句，以达到执行代码对服务器进行攻击的方法

## 参数占位符
* #{...}
* 执行 SQL 时，会将 #{...} 替换为 ?, 生成预编译 SQL，会自动设置参数值
* 使用时机：参数传递，都使用 #{...}
* 
* ${...}
* 拼接 SQL，直接将参数拼接在 SQL 语句中，存在 SQL 注入问题
* 使用时机：如果对表名、列表进行动态设置时使用

## 新增
* @Insert("...")
* 返回主键：
* @Options(useGeneratedKeys = true, keyProperty = "id")，会自动将生成的主键值，赋值给 emp 对象的 id 属性

## 更新
* @Update("...")

## 查询
* @Select("...")

## 数据封装
* 实体类属性名和数据库表查询返回的字段名一致，mybatis 会自动封装
* 如果实体类属性名和数据库表查询返回的字段名不一致，不能自动封装
* 1、起别名：在 SQL 语句中，对不一样的列名起别名，别名和实体类属性名一致
* @Select("select entry_date entryDate from tb_emp where id = 1")
* 2、手动结果映射：通过 @Results 及 @Result 进行手动结果映射
* @Results({
* @Result(column="entry_date", property="entryDate"),
* ...
* })
* 3、开启驼峰命名：如果字段名与属性名符合驼峰命名规则，mybatis 会自动通过驼峰命名规则映射
* mybatis.configuration.map-underscore-to-camel-case=true

## 多条件查询
* MySQL的 concat 函数，字符串拼接函数
* select concat('hello', ' mysql')
* 1、#{name} 的 name 就是 @Param("name") 中的 name
* 反射时获取的参数名要实际的，而非 args0，可以在 pom 里配置，这样就可以不用加  @Param("name") 注解了
```java
//@Select("select * from mybatis.tb_emp where name like concat('%', #{name}, '%') and " +
//        "gender = #{gender} and entry_date between #{start} and #{end} order by update_time desc")
//    List<Emp> getList(
//        String name,
//        Short gender,
//        LocalDate start,
//        LocalDate end
//    );

////    List<Emp> getList(
////        @Param("name") String name,
////        @Param("gender") Short gender,
////        @Param("start") LocalDate start,
////        @Param("end") LocalDate end
////    );
``` 

## XML 映射文件
* XML 映射文件的名称与 Mapper 接口名称一致，并且将 XML 映射文件和 Mapper 接口放置在相同包下（同包同名）
* XML 映射文件的 namespace 属性为 Mapper 接口全限定名一致
* XML 映射文件中 sql 语句的 id 和 Mapper 接口中的方法名一致，并保持返回类型一致
* resultType：单条记录所封装的类型