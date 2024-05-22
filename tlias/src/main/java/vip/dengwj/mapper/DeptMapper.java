package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import vip.dengwj.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    // 返回全部部门
    @Select("select * from talias.dept")
    List<Dept> getList();

    // 删除部门
    void deleteDept(String id);
}
