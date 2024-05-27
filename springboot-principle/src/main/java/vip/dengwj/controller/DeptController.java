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
// 一个完整的请求路径，应该是类上的 @RequestMapping 的 value 属性 + 方法上的 @RequestMapping 的 value 属性
@RequestMapping("/depts")
public class DeptController {
    @Resource
    private DeptService deptService;
    /**
     * 获取全部部门
     */
    // 指定请求方式为 GET
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result getList() {
        log.info("获取全部部门");
        List<Dept> list = deptService.getList();
        return Result.success(list);
    }

    // 删除部门
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable String id) {
        // {} 会替代 id
        log.info("删除部门: {}", id);
        deptService.deleteDept(id);
        return Result.success();
    }

    // 新增部门
    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        // 内部会帮 new 一个 dept 添加上前端传递来的值
        log.info("新增部门: {}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    // 编辑部门
    @PostMapping("/update")
    public Result updateDept(@RequestBody Dept dept) {
        log.info("编辑部门: {}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }

}
