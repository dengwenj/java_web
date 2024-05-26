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

## 通知类型
* 1、@Around：环绕通知，此注解标注的通知方法在目标方法前、后都被执行
* 2、@Before：前置通知，此注解标注的通知方法在目标方法前被执行
* 3、@After：后置通知，此注解标注的通知方法在目标方法后被执行，无论是否有异常都会执行
* 4、@AfterReturning：返回后通知，此注解标注的通知方法在目标方法后被执行，有异常不会执行
* 5、@AfterThrowing：异常后通知，此注解标注的通知方法发生异常后执行

## 注意事项
* @Around 环绕通知需要自己调用 ProceedingJoinPoint.proceed() 来让原始方法执行，其他通知不需要考虑目标方法执行
* @Around 环绕通知方法的返回值，必须指定为 Object，来接收原始方法的返回值
* @Before(前置通知)、@After(后置通知)、@Around(环绕通知)、@AfterReturning(返回后通知)、@AfterThrowing(异常后通知)

## PointCut
* 该注解的作用是将公共的切点表达式抽取出来，需要用到时引用该切点表达式

```java
@Component
@Aspect
public class MyAspect1 {
    @Pointcut("execution(* vip.dengwj.service.impl.DeptServiceImpl.*(..))")
    public void pj() {}

    @Before("pj()")
    public void before(JoinPoint joinPoint) {
        System.out.println("joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("before...");
    }

    @Around("pj()")
    // 这个是通知方法
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around after...");

        Object proceed = joinPoint.proceed();

        System.out.println("around after...");

        return proceed;
    }

    @After("pj()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after...");
    }

    @AfterReturning("pj()")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("pj()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }
}
```

## 通知顺序
* 当有多个切面的切入点都匹配到了目标方法，目标方法运行时，多个通知方法都会被执行
* 执行顺序：
* 1、不同切面类中，默认按照切面类的类名字母排序：
* 目标方法前的通知方法：字母排名靠前的先执行
* 目标方法后的通知方法：字母排名靠前的后执行
* 2、用 @Order(数字) 加在切面类上来控制顺序
* 目标方法前的通知方法：数字小的先执行
* 目标方法后的通知方法：数字小的后执行
```java
// 这样的执行顺序：
// 我是2前面
// 我是3前面
// 我是4前面
// 目标方法
// 我是4后面 
// 我是3后面
// 我是2后面
```
## 切入点表达式
* 切入点表达式：描述切入点方法的一种表达式
* 作用：主要用来决定项目中的哪些方法需要加入通知
* 常见形式：
* 1、execution(......)：根据方法的签名来匹配
* 2、@annotation(......)：根据注解匹配

## 切入点表达式-execution
* execution 主要根据方法的返回值、包名、类名、方法名、方法参数等信息来匹配：
* execution(访问修饰符? 返回值 包名.类名.?方法名(方法参数) throws 异常?)
* 其中带 ? 的表示可以省略的部分
* 访问修饰符：可省略
* 包名.类名：可省略
* throws 异常：可省略
* 可以使用通配符描述切入点：
* *：单个独立的任意符号，可以通配任意返回值、包名、类名、方法名、任意类型的一个参数，也可以通配包、类、方法名的一部分
* execution(* com.*.service.*update*(*))
* ..：多个连续的任意符号，可以通配任意层级的包，或任意类型、任意个数的参数
* execution(* com.dengwj..DeptService.*(..))
```java
@Component
@Aspect
public class MyAspect5 {
    // 匹配返回全部部门
    //@Pointcut("execution(public * vip.dengwj.service.DeptService.getList()))")
    // 匹配 vip.dengwj.service 包下的 DeptService 这个接口中所有的方法
    // @Pointcut("execution(* vip.dengwj.service.DeptService.*(..))")
    // 匹配查询全部和删除的
    @Pointcut("execution(* vip.dengwj.service.DeptService.getList()) || " +
        "execution(* vip.dengwj.service.DeptService.deleteDept(java.lang.String))")
    public void pc() {}

    @Around("pc()")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("来了吗");
        return joinPoint.proceed();
    }
}

```

## 注意事项
* 根据业务需要，可以使用 且(&&)、或(||)、非(!) 来组合比较复杂的切入点表达式

## 书写建议
* 所有业务方法名在命名时尽量规范，方便切入点表达式快速匹配。如：查询类方法都是 find 开头，更新类方法都是 update 开头
* 描述切入点方法通常基于接口描述，而不是直接描述实现类，增强拓展性
* 在满足业务需要的前提下，尽量缩小切入点的匹配范围。如：包名匹配尽量不使用..，使用 * 匹配单个包

## 切入点表达式-@annotation
* @annotation 切入点表达式，用于匹配标识有特定注解的方法
* @annotation(vip.dengwj.aop.MyLog)
```java
public class MyAspect5 {
    // 匹配返回全部部门
    //@Pointcut("execution(public * vip.dengwj.service.DeptService.getList()))")
    // 匹配 vip.dengwj.service 包下的 DeptService 这个接口中所有的方法
    // @Pointcut("execution(* vip.dengwj.service.DeptService.*(..))")
    // 匹配查询全部和删除的 这种可以用 @annotation 方法
    //@Pointcut("execution(* vip.dengwj.service.DeptService.getList()) || " +
    //    "execution(* vip.dengwj.service.DeptService.deleteDept(java.lang.String))")
    @Pointcut("@annotation(vip.dengwj.aop.MyLog)")
    public void pc() {}

    @Around("pc()")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("来了吗");
        return joinPoint.proceed();
    }
}
```

## 连接点
* 在 Spring 中用 JoinPoint 抽象了连接点，用它可以获得方法执行时的相关信息，如目标类名、方法名、方法参数等
* 对于 @Around 通知，获取连接点信息只能使用 ProceedingJoinPoint
* 对于其他四种通知，获取连接点信息只能使用 JoinPoint，它是 ProceedingJoinPoint 的父类型