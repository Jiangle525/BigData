package com.jiangle.bigevent.interceptor;

import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.utils.JwtUtils;
import com.jiangle.bigevent.utils.ThreadLocalUtils;
import com.jiangle.bigevent.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = request.getHeader("Authorization");
        try {
            // 解析 token
            User user = TokenUtils.parseToken(token, User.class);
            // 将解析 token 后得到的对象进行存储
            TokenUtils.setObject(user);
            // token 解析有效则放行
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // 设置状态码为401
            response.setStatus(401);
            // 不放行
            return false;
        }
    }

    // 请求结束后，释放token解析得到的对象
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TokenUtils.remove();
    }
}
