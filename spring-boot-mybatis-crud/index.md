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