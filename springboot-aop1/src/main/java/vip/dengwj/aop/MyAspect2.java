package vip.dengwj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
//@Aspect
//@Order(1)
public class MyAspect2 {
    // 这样的执行顺序：
    // 我是2前面
    // 我是3前面
    // 我是4前面
    // 目标方法
    // 我是4后面
    // 我是3后面
    // 我是2后面
    @Around("execution(* vip.dengwj.service.impl.DeptServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("我是2前面");
        Object proceed = joinPoint.proceed(); // 只会执行一次
        System.out.println("我是2后面");

        return proceed;
    }
}
