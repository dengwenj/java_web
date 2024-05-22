package vip.dengwj.service;

import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Page;

public interface EmpService {
    // 获取员工列表
    Page<Emp> getEmpList(Integer page, Integer pageSize, Emp emp);
}
