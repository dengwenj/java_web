package vip.dengwj.service.impl;

import vip.dengwj.dao.EmpDao;
import vip.dengwj.dao.impl.EmpDaoA;
import vip.dengwj.pojo.Emp;
import vip.dengwj.service.EmpService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpServiceA implements EmpService {
    private final EmpDao empDao = new EmpDaoA();

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
