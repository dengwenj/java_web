package vip.dengwj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyAspect3 {
    @Around("execution(* vip.dengwj.service.impl.DeptServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("我是3前面");
        Object proceed = joinPoint.proceed();
        System.out.println("我是3后面");

        return proceed;
    }
}
