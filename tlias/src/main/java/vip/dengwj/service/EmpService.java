package vip.dengwj.service;

import org.springframework.format.annotation.DateTimeFormat;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Page;

import java.time.LocalDate;

public interface EmpService {
    // 获取员工列表
    Page<Emp> getEmpList(
        Integer page,
        Integer pageSize,
        String name,
        Short gender,
        LocalDate start,
        LocalDate end);
}
