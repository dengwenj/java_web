package vip.dengwj.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.dengwj.pojo.Result;

/**
 * 全局异常处理器
 * Spring 里面的，没捕获的所有错误都会到这里来
 */
@RestControllerAdvice
// @RestControllerAdvice = @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
    // Exception.class 捕获所有异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}
