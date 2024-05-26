package vip.dengwj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Slf4j
// 控制反转，保存到 bean 容器对象中
@Component
// aop
//@Aspect
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
