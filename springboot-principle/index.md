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

## 自定义 starter
* 在实际开发中，经常会定义一些公共组件，提供给各个项目团队使用。而在 SpringBoot 的项目中，一般会将这些公共组件封装为 Springboot 的 starter
* 例：
* Maven: org.springframework.boot:spring-boot-autoconfigure:2.7.5 // 自动配置功能
* Maven: org.springframework.boot:spring-boot-starter-web:2.7.5 // 依赖管理功能
* Maven: org.mybatis.spring.boot:mybatis-spring-boot-autoconfigure:2.2.2 // 自动配置功能
* Maven: org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2 // 依赖管理功能

## 需求
* 自定义 aliyun-oss-spring-boot-starter，完成阿里云 oss 操作工具类 AliyunOSSUtils 的自动配置
* 目标：引入起步依赖之后，想要使用阿里云 oss，注入 AliyunOSSUtils 直接使用即可

## 步骤
* 创建 aliyun-oss-spring-boot-starter 模块
* 创建 aliyun-oss-spring-boot-autoconfigure 模块，在 starter 中引入该模块
* 在 aliyun-oss-spring-boot-autoconfigure 模块中的定义自动配置功能，并w定义自动配置文件 META-INF/spring/xxxx.imports

## 自动配置类
* 自己封装的自动配置类要想被 spring 加载到要在一份固定的配置文件中配置，spring 启动的时候就会加载这份文件

## Maven 高级
* 分模块设计
* 为什么？将项目按照功能拆分成若干个子模块，方便项目的管理维护、扩展、也方便模块间的相互调用，资源共享

## 什么是分模块设计？
* 将项目按照功能拆分成若干个子模块

## 注意事项
* 分模块设计需要先针对模块功能进行设计，在进行编码。不会先将工程开发完毕，然后进行拆分

## 继承
* 概念：继承描述的是两个工程间的关系，与 java 中的继承相似，子工程可以继承父工程中的配置信息，常见于依赖关系的继承
* 作用：简化依赖配置、统一管理依赖
* 实现：<parent>...</parent>

## 继承关系实现
* 1、创建 maven 模块 tlias-parent，该工程为父工程，设置打包方式 pom，<packaging>pom</packaging>
* 2、在子工程的 pom.xml 文件中，配置继承关系
* 3、 （子工程会自动继承父工程的依赖）
* jar: 普通模块打包，springboot 项目基本都是 jar 包(内嵌 tomcat 运行)
* war: 普通 web 程序打包，需要部署在外部的 tomcat 服务器中运行
* pom: 父工程或聚合工程，该模块不写代码，仅进行依赖管理

## 注意事项
* 在子工程中，配置了继承关系之后，坐标中的 groupId 是可以省略的，因为会自动继承父工程的
* relativePath 指定父工程的 pom 文件的相对位置（如果不指定，将从本地仓库/远程仓库查找该工程）
* 若父子工程都配置了同一个依赖的不同版本，以子工程的为准

## 锁定版本
* 在 maven 中，可以在父工程的 pom 文件中通过 <dependencyManagement> 来统一管理依赖版本
* 子工程引入依赖时，无需指定 <version> 版本号，父工程统一管理。变更依赖版本，只需在父工程中统一变更

## 自定义属性/引用属性
* <properties><lombok.version>1.18.24</lombok.version></properties>
* 然后用 ${lombok.version} 引用

## <dependencyManagement> 和 <dependencies> 的区别是什么？
* <dependencies>是直接依赖，在父工程配置了依赖子工程会直接继承下来
* <dependencyManagement>是统一管理依赖版本，不会直接依赖，还需要在子工程中引入所需依赖(无需指定版本)
