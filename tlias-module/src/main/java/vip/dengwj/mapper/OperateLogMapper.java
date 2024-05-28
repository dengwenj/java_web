package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import vip.dengwj.pojo.OperateLog;

@Mapper
public interface OperateLogMapper {
    @Insert("insert into talias.operate_log " +
        "(operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
        "values (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog operateLog);
}
