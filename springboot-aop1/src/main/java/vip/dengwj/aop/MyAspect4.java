package vip.dengwj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyAspect4 {
    @Around("execution(* vip.dengwj.service.impl.DeptServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("我是4前面");
        Object proceed = joinPoint.proceed();
        System.out.println("我是4后面");

        return proceed;
    }
}
