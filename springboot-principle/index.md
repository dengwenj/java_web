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

## 第三方 bean
* @Bean：
* 1、如果要管理的 bean 对象来自于第三方（不是自定义的），是无法用 @Component 及衍生注解声明 bean 的，就需要用到 @Bean 注解
* 2、若要管理的第三方 bean 对象，建议对这些 bean 进行集中分类配置，可以通过 @Configuration 注解声明一个配置类
```java
@Configuration
public class CommonConfig {
    // 将当前方法的返回值对象交给 IOC 容器管理，成为 IOC 容器 bean
    // 通过 @Bean 注解的 name/value 属性指定 bean 名称，如果未指定，默认是方法名
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}
```

## 注意事项
* 通过 @Bean 注解的 name或value 属性可以声明 bean 的名称，如果不指定，默认 bean 的名称就是方法名
* 如果第三方 bean 需要依赖其它 bean 对象，直接在 bean 定义方法中设置形参即可，容器会根据类型自动装配