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

    // 新增部门
    void addDept(Dept dept);

    // 编辑部门
    void updateDept(Dept dept);

    // 根据 id 获取部门
    Dept getDeptById(String id);
}
