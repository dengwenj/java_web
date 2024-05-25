package vip.dengwj.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.dengwj.global.ConstantGlobal;
import vip.dengwj.pojo.Result;
import vip.dengwj.utils.JWTUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 获取 url
        String url = req.getRequestURL().toString();

        // 如果是 login 请求，放行
        if (url.contains("login")) {
            filterChain.doFilter(req, resp);
            return;
        }

        // 判断请求 url 中是否包含 login，包含走后面，不包含说明没登录
        String token = req.getHeader("token");
        if (token == null || token.isEmpty()) {
            LoginCheckFilter.ResErr(resp);
            return;
        }

        try {
            // 令牌是有效的
            Map<String, Object> map = jwtUtils.parseToken(token);
            req.setAttribute(ConstantGlobal.USERINFO, map);
            // 放行
            filterChain.doFilter(req, resp);
        } catch (Exception e) {
            log.error("令牌失效：{}", e.getMessage());
            LoginCheckFilter.ResErr(resp);
        }
    }

    private static void ResErr(HttpServletResponse resp) throws IOException {
        // 返回错误结果
        Result err = Result.error(ConstantGlobal.NOT_LOGIN);
        String jsonString = JSONObject.toJSONString(err);
        resp.getWriter().write(jsonString);
    }
}
