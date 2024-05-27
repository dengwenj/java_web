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

## bean 作用域
* Spring 支持五种作用域，后三种在web环境才生效
* 作用域：
* singleton：容器内同名称的 bean 只有一个实例（单例）默认
* prototype：每次使用该 bean 时会创建新的实例（非单例）
* 可以通过 @Scope 注解来进行配置作用域：
* @Scope("prototype")

## 注意事项
* 默认 singleton 的 bean，在容器启动时被创建，可以使用 @Lazy 注解来延迟初始化（延迟到第一次使用时）
* prototype 的 bean，每一次使用该 bean 的时候都会创建一个新的实例
* 实际开发中，绝大部分的 Bean 是单例的，也就是说绝大部分 Bean 不需要配置 scope 属性