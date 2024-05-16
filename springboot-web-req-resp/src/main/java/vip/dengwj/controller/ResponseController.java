package vip.dengwj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Address;
import vip.dengwj.pojo.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 响应数据
 */
@RestController
public class ResponseController {
    // 返回字符串
    @RequestMapping("/respStr")
    public Result respStr() {
        return Result.success("你好，朴睦");
    }

    // 返回对象
    @RequestMapping("/respObject")
    public Result respObject() {
        Address address = new Address();
        address.setProvince("湖北");
        address.setCity("武汉");
        return Result.success(address);
    }

    // 返回集合
    @RequestMapping("/respList")
    public Result respList() {
        List<Address> list = new ArrayList<>();
        Collections.addAll(list, new Address("广东", "广州"), new Address("广东", "深圳"));
        return Result.success(list);
    }
}
