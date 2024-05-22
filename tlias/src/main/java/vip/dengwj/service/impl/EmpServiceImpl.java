package vip.dengwj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.dengwj.mapper.EmpMapper;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Page;
import vip.dengwj.service.EmpService;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public Page<Emp> getEmpList(Integer page, Integer pageSize, Emp emp) {
        Integer formatPage = (page - 1) * pageSize;
        // 获取员工列表
        List<Emp> list = empMapper.getEmpList(formatPage, pageSize, emp);
        // 获取员工数量
        long total = empMapper.getEmpCount();

        return new Page<>(total, list);
    }
}
