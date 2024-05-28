package vip.dengwj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vip.dengwj.mapper.DeptLogMapper;
import vip.dengwj.pojo.DeptLog;
import vip.dengwj.service.DeptLogService;

import javax.annotation.Resource;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Resource
    private DeptLogMapper deptLogMapper;

    // 事务管理
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addDeptLog(DeptLog deptLog) {
        deptLogMapper.addDeptLog(deptLog);
    }
}
