package vip.dengwj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.dengwj.mapper.EmpMapper;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootMybatisCrudApplicationTests {
    @Resource
    private EmpMapper empMapper;

    @Test
    public void testDeleteEmp() {
        int i = empMapper.deleteEmp(26);
        System.out.println(i);
    }
}
