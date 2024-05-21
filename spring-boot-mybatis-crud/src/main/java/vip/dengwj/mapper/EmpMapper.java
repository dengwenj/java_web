package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import vip.dengwj.pojo.Emp;

@Mapper
public interface EmpMapper {
    // ${} 不会预编译，sql 注入
    // @Delete("delete from mybatis.tb_emp where id = ${id}")
    // #{} 动态
    @Delete("delete from mybatis.tb_emp where id = #{id}")
    int deleteEmp(Integer id);

    @Insert("insert into tb_emp (username, name, gender, image, job, entry_date, dept_id, create_time, update_time)" +
        "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insertEmp(Emp emp);
}
