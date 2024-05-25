package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.dengwj.pojo.Emp;

import java.time.LocalDate;
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
//    @Select("select * from talias.emp ")
    List<Emp> list(
        String name,
        Short gender,
        LocalDate start,
        LocalDate end
    );

    // 删除员工
    void deleteByIds(List<String> ids);

    // 新增员工
    void addEmp(Emp emp);

    // 根据 id 查询员工
    Emp getEmpById(Long id);

    // 修改员工
    void updateEmp(Emp emp);

    // 根据用户名和密码查询
    Emp getEmpByUsernameAndPassword(Emp emp);
}
