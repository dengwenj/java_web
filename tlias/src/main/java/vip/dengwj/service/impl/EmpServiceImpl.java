package vip.dengwj.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.dengwj.mapper.EmpMapper;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Page;
import vip.dengwj.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    //@Override
    //public Page<Emp> getEmpList(Integer page, Integer pageSize, Emp emp) {
    //    Integer formatPage = (page - 1) * pageSize;
    //    // 获取员工列表
    //    List<Emp> list = empMapper.getEmpList(formatPage, pageSize, emp);
    //    // 获取员工数量
    //    long total = empMapper.getEmpCount();
    //
    //    return new Page<>(total, list);
    //}

    // 使用 pagehelper 分页插件获取列表
    @Override
    public Page<Emp> getEmpList(
        Integer page,
        Integer pageSize,
        String name,
        Short gender,
        LocalDate start,
        LocalDate end
    ) {
        PageHelper.startPage(page, pageSize);

        List<Emp> list = empMapper.list(
            name,
            gender,
            start,
            end
        );
        com.github.pagehelper.Page<Emp> page1 = (com.github.pagehelper.Page<Emp>) list;
        return new Page<>(page1.getTotal(), page1.getResult());
    }

    @Override
    public void deleteByIds(List<String> ids) {
        empMapper.deleteByIds(ids);
    }

    // 新增员工
    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public Emp getEmpById(Long id) {
        Emp emp = empMapper.getEmpById(id);
        return emp;
    }
}
