package vip.dengwj.service;

import vip.dengwj.pojo.Dept;

import java.util.List;

public interface DeptService {
    // 返回全部部门
    List<Dept> getList();

    // 删除部门
    void deleteDept(String id);
}
