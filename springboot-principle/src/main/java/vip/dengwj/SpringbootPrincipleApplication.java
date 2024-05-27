package vip.dengwj;

import com.example.EnableHeaderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 默认组件扫描器是在本包下扫描
//@ComponentScan({"com.example", "vip.dengwj"})
//@Import({HeaderConfig.class})
//@Import({MyImportSelector.class})
// 会自动的导入到 ioc 容器
@EnableHeaderConfig
@SpringBootApplication
public class SpringbootPrincipleApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过指定class文件的路径来获取对应的Java类
        Class<?> aClass = SpringbootPrincipleApplication.class
            .getClassLoader()
            .loadClass("vip.dengwj.controller.DeptController");
        System.out.println(aClass); // DeptController 类

        SpringApplication.run(SpringbootPrincipleApplication.class, args);
    }

}
