package vip.dengwj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.dengwj.mapper.UserMapper;

// springboot 整合单元测试的注解
@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests { 
    // 依赖注入
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        userMapper.list().forEach(System.out::println);
    }
}
