package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Page;
import vip.dengwj.pojo.Result;
import vip.dengwj.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    // 获取员工列表
    @GetMapping("/emp")
    public Result getEmpList(
        // 默认值
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize,
        String name,
        Short gender,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info("获取员工列表：{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, start, end);
        Page<Emp> empPage = empService.getEmpList(
            page,
            pageSize,
            name,
            gender,
            start,
            end
        );
        return Result.success(empPage);
    }

    // 删除员工
    @PostMapping("/emp/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {
        log.info("删除员工: {}", ids);

        empService.deleteByIds(ids);
        return Result.success();
    }

    // 新增员工
    @PostMapping("/emp/add")
    public Result addEmp(@RequestBody Emp emp) {
        log.info("新增员工：{}", emp.toString());
        empService.addEmp(emp);
        return Result.success();
    }

    // 根据 id 查询数据
    @GetMapping("/emp/{id}")
    public Result getEmpById(@PathVariable Long id) {
        log.info("根据 id 查询数据, {}", id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }
}
