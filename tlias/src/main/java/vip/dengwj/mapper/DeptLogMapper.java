package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import vip.dengwj.pojo.DeptLog;

@Mapper
public interface DeptLogMapper {
    // 添加日志
    @Insert("insert into talias.dept_log (log, create_time) values (#{log}, #{createTime})")
    void addDeptLog(DeptLog deptLog);
}
