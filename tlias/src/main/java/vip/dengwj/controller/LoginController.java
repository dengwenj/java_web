package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Result;
import vip.dengwj.service.EmpService;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp emp1 = empService.login(emp);
        return emp1 != null ? Result.success() : Result.error("用户名或密码错误");
    }
}
