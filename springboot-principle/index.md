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

## springboot 起步依赖原理
* 就是 maven 的依赖传递

## springboot 自动配置
* springboot 的自动配置就是当 spring 容器启动后，一些配置类、bean 对象就自动存入到了 IOC 容器中，不需要我们手动去声明，从而简化了开发，省去了繁琐的配置操作

## 自动配置原理
* 方案一：@ComponentScan 组件扫描
* @ComponentScan({"com.example", "vip.dengwj"})
* 方案二：@Import 导入。使用 @Import 导入的类会被 spring 加载到 IOC 容器中，导入形式主要有以下几种：
* 导入普通类
* 导入配置类
* 导入 ImportSelector 接口实现类
* @EnableXxxx注解，封装 @Import 注解
* 在项目当中引入第三方依赖之后，如何加载第三方依赖当中定义好的 bean 以及配置类，从而完成自动配置操作

## @Configuration
* 配置类：可以用来声明第三方bean，把第三方的类交给 ioc 容器管理

## @SpringBootApplication
* 该注解标识在 SpringBoot 工程引导类上，是 SpringBoot 中最重要的注解，该注解由三个部分组成：
* 1、@SpringBootConfiguration：该注解与 @Configuration 注解作用相同，用来声明当前也是一个配置类
* 2、@ComponentScan：组件扫描，默认扫描当前引导类所在包及其子包
* 3、@EnableAutoConfiguration：SpringBoot 实现自动化配置的核心注解

## @Conditional
* 作用：按照一定的条件进行判断，在满足给定条件后才会注册对应的 bean 对象到 spring ioc 容器中
* 位置：方法、类
* @Conditional 本身是一个父注解，派生出大量的子注解：
* @ConditionalOnClass：判断环境中是否有对应字节码文件，才注册 bean 到 ioc 容器
* @ConditionalOnMissingBean：判断环境中有没有对应的 bean（类型或名称），没有才注册 bean 到 ioc 容器
* @ConditionalOnProperty：判断配置文件中有对应属性和值，才注册 bean 到 ioc 容器