package vip.dengwj.service.impl;

import org.springframework.stereotype.Service;
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
    public List<Dept> getList() {
        List<Dept> list = deptMapper.getList();
        return list;
    }
}
