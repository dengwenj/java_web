package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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

    // 删除部门
    @DeleteMapping("/depts/{id}")
    public Result deleteDept(@PathVariable String id) {
        // {} 会替代 id
        log.info("删除部门: {}", id);
        deptService.deleteDept(id);
        return Result.success();
    }
}
