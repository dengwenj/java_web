## AOP 概述
* AOP：Aspect Oriented Programming（面向切面变成、面向方面编程），其实就是面向特定方法编程
* 场景：案例部分功能运行较慢，定位执行耗时较长的业务方法，此时需要统计每一个业务方法的执行耗时
* 实现：动态代理是面向切面编程最主流的实现。而 SpringAOP 是 Spring 框架的高级技术，只在管理 bean 对象的过程中，主要通过底层的动态代理机制，对特定的方法进行编程

## AOP
* 场景：记录操作日志、权限控制、事务管理...
* 优势：代码无侵入、减少重复代码、提交开发效率、维护方便

## AOP 核心概念
* 连接点：JoinPoint，可以被 AOP 控制的方法（暗含方法执行时相关信息）
* 通知：Advice，指哪些重复的逻辑，也就是共性功能（最终体现为一个方法）
* 切入点：PointCut，匹配连接点的条件，通知仅会在切入点方法执行时被应用，（切入点表达式）
* 切面：Aspect，描述通知与切入点的对应关系（通知 + 切入点）
* 目标对象：Target，通知所应用的对象
* 一旦进行了 aop 的开发，运行的就不再是原始的目标对象，而是基于目标对象生成的代理对象
```java
@Slf4j
// 控制反转，保存到 bean 容器对象中
@Component
// aop
@Aspect
public class TimeAspect {
    @Around("execution(* vip.dengwj.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info("耗时时间: {} ms", end - start);

        return result;
    }
}

```