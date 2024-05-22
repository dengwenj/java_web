package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import vip.dengwj.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {
    // 获取员工数量
    long getEmpCount();

    // 获取员工列表
//    List<Emp> getEmpList(
//        Integer page,
//        Integer pageSize,
//        Emp emp
//    );
//    List<Emp> getEmpList(
//        @Param("page") Integer page,
//        @Param("pageSize") Integer pageSize,
//        @Param("emp") Emp emp
//    );

    // 使用 pagehelper 分页插件获取列表
    @Select("select * from talias.emp")
    List<Emp> list();
}
