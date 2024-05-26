package vip.dengwj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
