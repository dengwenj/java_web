package vip.dengwj.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.dengwj.mapper.OperateLogMapper;
import vip.dengwj.pojo.OperateLog;
import vip.dengwj.utils.JWTUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

// 将 增、删、改 相关接口的操作日志记录到数据库表中
// 日志信息包含：操作人、操作时间、执行方法的全类名、执行方法名、方法运行时参数、返回值、方法执行时长
@Component
@Aspect
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private JWTUtils jwtUtils;

    @Around("@annotation(vip.dengwj.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 操作人
        String token = request.getHeader("token");
        Map<String, Object> map = jwtUtils.parseToken(token);
        String username = (String) map.get("username");

        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 执行方法的全类名
        String className = joinPoint.getTarget().getClass().getName();

        // 执行方法名
        String methodName = joinPoint.getSignature().getName();

        // 方法运行时参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        // 返回值
        Object returnValue = joinPoint.proceed();
        String formatReturnValue = JSONObject.toJSONString(returnValue);

        // 方法执行时长
        long endTime = System.currentTimeMillis();
        Long costTime = endTime - startTime;

        OperateLog operateLog = new OperateLog(
            null,
            username,
            operateTime,
            className,
            methodName,
            methodParams,
            formatReturnValue,
            costTime
        );
        operateLogMapper.insert(operateLog);

        return returnValue;
    }
}
