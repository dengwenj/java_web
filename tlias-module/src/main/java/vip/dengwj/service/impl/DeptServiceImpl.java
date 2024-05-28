package vip.dengwj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.dengwj.anno.Log;
import vip.dengwj.mapper.DeptMapper;
import vip.dengwj.mapper.EmpMapper;
import vip.dengwj.pojo.Dept;
import vip.dengwj.pojo.DeptLog;
import vip.dengwj.service.DeptLogService;
import vip.dengwj.service.DeptService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private EmpMapper empMapper;
    @Resource
    private DeptLogService deptLogService;

    /**
     * 返回全部部门
     */
    @Override
    @Log
    public List<Dept> getList() {
        List<Dept> list = deptMapper.getList();
        return list;
    }

    // 删除部门
    // spring 开启事务
    @Transactional(rollbackFor = Exception.class) // 任何异常都要回滚
    @Override
    public void deleteDept(String id) {
        try {
            // 根据 id 删除部门
            deptMapper.deleteDept(id);

            int i = 1 / 0;

            // 根据部门 id 删除该部门下的员工
            empMapper.deleteEmpByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setLog("删除部门数据成功了吗");
            deptLog.setCreateTime(LocalDateTime.now());
            deptLogService.addDeptLog(deptLog);
        }
    }

    // 新增部门
    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

    // 编辑部门
    @Override
    @Log
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }

    // 根据 id 获取部门
    @Override
    public Dept getDeptById(String id) {
        return deptMapper.getDeptById(id);
    }
}
