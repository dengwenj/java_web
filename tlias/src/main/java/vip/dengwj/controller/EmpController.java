package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
