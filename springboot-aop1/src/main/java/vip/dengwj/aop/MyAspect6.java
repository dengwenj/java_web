package vip.dengwj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAspect6 {
    @Pointcut("execution(* vip.dengwj.service.DeptService.*(..))")
    public void pc() {}

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标对象的类名
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("获取目标对象的类名: " + name);

        // 获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("获取目标方法的方法名" + methodName);

        // 获取目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("获取目标方法运行时传入的参数" + Arrays.toString(args));

        // 放行，目标方法执行
        Object proceed = joinPoint.proceed();

        // 获取目标方法运行的返回值
        System.out.println("获取目标方法运行的返回值" + proceed);

        return proceed;
    }
}
