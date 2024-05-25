package vip.dengwj.interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import vip.dengwj.global.ConstantGlobal;
import vip.dengwj.pojo.Result;
import vip.dengwj.utils.JWTUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Resource
    JWTUtils jwtUtils;

    // 目标资源方法执行前执行，返回 true：放行，返回 false：不放行
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        // 获取 url
        String url = req.getRequestURL().toString();

        // 如果是 login 请求，放行 排除掉了，可以不用写
        //if (url.contains("login")) {
        //    filterChain.doFilter(req, resp);
        //    return;
        //}

        // token 有没有值，没有说明没登录
        String token = req.getHeader("token");
        if (token == null || token.isEmpty()) {
            LoginCheckInterceptor.ResErr(resp);
            // 不放行
            return false;
        }

        try {
            // 令牌是有效的
            Map<String, Object> map = jwtUtils.parseToken(token);
            req.setAttribute(ConstantGlobal.USERINFO, map);
        } catch (Exception e) {
            log.error("令牌失效：{}", e.getMessage());
            LoginCheckInterceptor.ResErr(resp);
        }

        //令牌是有效放行
        return true;
    }

    // 目标资源方法执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    // 视图渲染完毕后执行，最后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

    private static void ResErr(HttpServletResponse resp) throws IOException {
        // 返回错误结果
        Result err = Result.error(ConstantGlobal.NOT_LOGIN);
        String jsonString = JSONObject.toJSONString(err);
        resp.getWriter().write(jsonString);
    }
}
