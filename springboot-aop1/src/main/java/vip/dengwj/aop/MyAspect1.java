package vip.dengwj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Aspect
public class MyAspect1 {
    @Pointcut("execution(* vip.dengwj.service.impl.DeptServiceImpl.*(..))")
    public void pj() {}

    @Before("pj()")
    public void before(JoinPoint joinPoint) {
        System.out.println("joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("before...");
    }

    @Around("pj()")
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
