package vip.dengwj;

import com.google.gson.Gson;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import vip.dengwj.controller.DeptController;
import vip.dengwj.pojo.Result;

@SpringBootTest
class SpringbootPrincipleApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private SAXReader saxReader;
    @Autowired
    private Gson gson;

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

    @Test
    void test2() {
        for (int i = 0; i < 10; i++) {
            Object bean = applicationContext.getBean("deptController");
            System.out.println(bean);
        }
    }

    @Test
    void test3() {
        System.out.println(saxReader);
    }

    @Test
    void test4() {
        System.out.println("gson.toJson(Result.success()) = " + gson.toJson(Result.success()));
    }

    @Test
    public void testTokenParser() {
        System.out.println(applicationContext.getBean("tokenParser"));
    }

    @Test
    public void testHeaderParser() {
        System.out.println(applicationContext.getBean("headerParser"));
    }

    @Test
    public void testConfig() {
        System.out.println(applicationContext.getBean("headerParser"));
    }
}
