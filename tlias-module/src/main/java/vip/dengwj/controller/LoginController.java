package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Result;
import vip.dengwj.service.EmpService;
import vip.dengwj.utils.JWTUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;
    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp emp1 = empService.login(emp);

        // 登录成功返回令牌
        if (emp1 != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", emp1.getId());
            data.put("name", emp1.getName());
            data.put("username", emp1.getUsername());

            String jwt = jwtUtils.generateToken(data);
            return Result.success(jwt);
        }

        // 登录失败
        return Result.error("用户名或密码错误");
    }
}
