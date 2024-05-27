## 获取 bean
* 默认情况下，Spring 项目启动时，会把 bean 都创建好放在 ioc 容器中，如果想要主动获取这些 bean，可以通过如下方式：
* 根据 name 获取 bean：Object getBean(String name)
* 根据类型获取 bean：<T> T getBean(Class<T> requiredType)
* 根据 name 获取 bean(带类型转换)：<T> T getBean(String name, Class<T> requiredType)
```java
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
```