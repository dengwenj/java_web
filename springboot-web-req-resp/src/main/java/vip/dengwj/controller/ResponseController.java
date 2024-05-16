package vip.dengwj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Address;

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
    public String respStr() {
        return "你好，朴睦";
    }

    // 返回对象
    @RequestMapping("/respObject")
    public Address respObject() {
        Address address = new Address();
        address.setProvince("湖北");
        address.setCity("武汉");
        return address;
    }

    // 返回集合
    @RequestMapping("/respList")
    public List<Address> respList() {
        List<Address> list = new ArrayList<>();
        Collections.addAll(list, new Address("广东", "广州"), new Address("广东", "深圳"));
        return list;
    }
}
