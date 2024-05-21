package vip.dengwj.mapper;

import org.apache.ibatis.annotations.*;
import vip.dengwj.pojo.Emp;

@Mapper
public interface EmpMapper {
    // 删除
    // ${} 不会预编译，sql 注入
    // @Delete("delete from mybatis.tb_emp where id = ${id}")
    // #{} 动态
    @Delete("delete from mybatis.tb_emp where id = #{id}")
    int deleteEmp(Integer id);

    // 新增
    // 返回主键，往 emp 中的 id 属性中封装
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tb_emp (username, name, gender, image, job, entry_date, dept_id, create_time, update_time)" +
        "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insertEmp(Emp emp);

    // 更新
    @Update("update tb_emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, " +
        "entry_date = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id};")
    void updateEmp(Emp emp);
}
