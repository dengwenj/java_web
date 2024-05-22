package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Dept;
import vip.dengwj.pojo.Result;
import vip.dengwj.service.DeptService;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Resource
    private DeptService deptService;
    /**
     * 获取全部部门
     */
    // 指定请求方式为 GET
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result getList() {
        log.info("获取全部部门");
        List<Dept> list = deptService.getList();
        return Result.success(list);
    }
}
