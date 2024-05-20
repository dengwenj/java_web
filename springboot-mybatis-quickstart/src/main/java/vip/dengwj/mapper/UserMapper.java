package vip.dengwj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import vip.dengwj.pojo.User;

import java.util.List;

// 在运行时，会自动生成该接口的实现类对象(代理对象)，并且将该对象交给 IOC 容器管理
@Mapper
public interface UserMapper {
    // 查询全部用户信息
    @Select("select * from user")
    public abstract List<User> list();
}
