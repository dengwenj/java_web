## Mybatis 删除
* delete from emp where id = 10;
* 接口方法：
* @Delete("delete from emp where id = #{id}")
* int deleteEmp(Integer id);
* 如果 mapper 接口方法形参只有一个普通类型的参数，#{...}里面的属性名可以随便写，如：#{id}、#{value}