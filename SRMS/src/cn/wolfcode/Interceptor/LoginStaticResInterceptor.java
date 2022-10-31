package cn.wolfcode.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: 未登录是不能访问静态资源的(.jsp .css)  可以访问(login.css login.jsp .css .png)  先进入到拦截器
 * @description:
 * @author: Mr.Like
 * @create: 2022-08-18 20:58
 **/
@Component
public class LoginStaticResInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器"+request.getRequestURI());
        return false;
    }
}
