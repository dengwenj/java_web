package vip.dengwj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.dengwj.mapper.EmpMapper;
import vip.dengwj.pojo.Emp;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testUpdateEmp() {
        Emp emp = new Emp();
        emp.setId(29);
        emp.setUsername("zhanghua1");
        emp.setName("张华1");
        emp.setGender((short) 1);
        emp.setImage("zh.jpg");
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.now());
        emp.setDeptId(2);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.updateEmp(emp);
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(29);
        System.out.println(emp);
    }

    @Test
    public void testGetList() {
//        List<Emp> list = empMapper.getList(
//            "苏",
//            (short) 1,
//            LocalDate.of(2024, 1, 1),
//            LocalDate.of(2024, 5, 21)
//        );
        List<Emp> list = empMapper.getList(
            "苏",
            null,
            null,
            null
        );
        System.out.println(list);
    }

    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(29);
        emp.setName("张华29");
        empMapper.update2(emp);
    }

    @Test
    public void testDeleteIds() {
        List<Integer> integers = Arrays.asList(23, 24, 25);
        empMapper.deleteIds(integers);
    }
}
