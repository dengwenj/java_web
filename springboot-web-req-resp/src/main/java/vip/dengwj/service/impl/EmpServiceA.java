package vip.dengwj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.dengwj.mapper.EmpDao;
import vip.dengwj.pojo.Emp;
import vip.dengwj.service.EmpService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
//@Component // 将当前类交给 IOC 容器管理，成为 IOC 容器中的 bean
public class EmpServiceA implements EmpService {
    @Autowired // 运行时，IOC 容器会提供该类型的 bean 对象，并赋值给该变量 - 依赖注入
    private EmpDao empDao;

    @Override
    public List<Emp> getEmpList() throws Exception {
        List<Emp> empList = empDao.getEmpList();

        Map<String, String> map = new HashMap<>();
        map.put("1", "程序员");
        map.put("2", "学生");
        map.put("3", "老师");

        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "男");
        map1.put("0", "女");

        for (Emp emp : empList) {
            emp.setGender(map1.get(emp.getGender()));
            emp.setJob(map.get(emp.getJob()));
        }

        return empList;
    }
}
