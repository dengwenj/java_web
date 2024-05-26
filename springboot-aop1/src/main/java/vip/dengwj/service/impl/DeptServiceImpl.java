package vip.dengwj.service.impl;

import org.springframework.stereotype.Service;
import vip.dengwj.aop.MyLog;
import vip.dengwj.mapper.DeptMapper;
import vip.dengwj.pojo.Dept;
import vip.dengwj.service.DeptService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    /**
     * 返回全部部门
     */
    @Override
    @MyLog
    public List<Dept> getList() {
        System.out.println("金额几节课进去阿胶蒋佳坤看见开启可洁可净");
        List<Dept> list = deptMapper.getList();
        return list;
    }

    // 删除部门
    @Override
    @MyLog
    public void deleteDept(String id) {
        deptMapper.deleteDept(id);
    }

    // 新增部门
    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

    // 编辑部门
    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
}
