package vip.dengwj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.dengwj.pojo.Emp;
import vip.dengwj.pojo.Result;
import vip.dengwj.util.XMLParse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class EmpController {
    @RequestMapping("/getPerson")
    public Result getPerson() throws Exception {
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        System.out.println(file); // /Users/dengwenjie/Java/java_web/springboot-web-req-resp/target/classes/emp.xml
        // "springboot-web-req-resp/src/main/resources/emp.xml"
        List<Emp> list = XMLParse.xmlParse(file, Emp.class);

        Map<String, String> map = new HashMap<>();
        map.put("1", "程序员");
        map.put("2", "学生");
        map.put("3", "老师");

        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "男");
        map1.put("0", "女");

        for (Emp emp : list) {
            emp.setGender(map1.get(emp.getGender()));
            emp.setJob(map.get(emp.getJob()));
        }
        return Result.success(list);
    }
}


// TODO 研究
//import java.util.HashMap;
//    import java.util.Map;
//    import java.util.function.Function;
//
//public class IfMappingExample {
//
//    public static void main(String[] args) {
//        // 初始化映射
//        Map<String, Function<String, String>> mapping = new HashMap<>();
//        mapping.put("handleA", IfMappingExample::handleA);
//        mapping.put("handleB", IfMappingExample::handleB);
//        // ... 可以添加更多映射
//
//        // 测试映射
//        String input = "handleA";
//        String result = mapping.get(input).apply(input);
//        System.out.println(result);
//    }
//
//    // 示例处理方法
//    public static String handleA(String input) {
//        return "Handling A: " + input;
//    }
//
//    public static String handleB(String input) {
//        return "Handling B: " + input;
//    }
//
//    // ... 可以添加更多处理方法
//}