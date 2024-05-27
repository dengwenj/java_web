package vip.dengwj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import vip.dengwj.controller.DeptController;

@SpringBootTest
class SpringbootPrincipleApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        // 通过名称获取 bean 对象
        Object bean1 = applicationContext.getBean("deptController");
        System.out.println(bean1);

        // 通过类型获取 bean 对象
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

        // 通过名称和类型获取 bean 对象
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);
    }

}
