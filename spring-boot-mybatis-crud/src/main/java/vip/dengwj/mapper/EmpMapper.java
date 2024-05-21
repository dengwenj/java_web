package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    // ${} 不会预编译，sql 注入
    // @Delete("delete from mybatis.tb_emp where id = ${id}")
    // #{} 动态
    @Delete("delete from mybatis.tb_emp where id = #{id}")
    int deleteEmp(Integer id);
}
