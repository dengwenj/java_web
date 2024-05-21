package vip.dengwj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.dengwj.mapper.EmpMapper;
import vip.dengwj.pojo.Emp;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SpringBootMybatisCrudApplicationTests {
    @Resource
    private EmpMapper empMapper;

    @Test
    public void testDeleteEmp() {
        int i = empMapper.deleteEmp(26);
        System.out.println(i);
    }

    @Test
    public void testInsertEmp() {
        Emp emp = new Emp();
        emp.setUsername("zhanghua1");
        emp.setName("张华");
        emp.setGender((short) 1);
        emp.setImage("z.jpg");
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.now());
        emp.setDeptId(2);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insertEmp(emp);

        System.out.println(emp.getId());
    }
}
