package vip.dengwj.service;

import vip.dengwj.pojo.Dept;

import java.util.List;

public interface DeptService {
    // 返回全部部门
    List<Dept> getList();

    // 删除部门
    void deleteDept(String id);

    // 新增部门
    void addDept(Dept dept);

    // 编辑部门
    void updateDept(Dept dept);
}
