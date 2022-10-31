package cn.wolfcode.Interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: SRMS
 * @description:未登录不能访问jsp
 * @author: Mr.Like
 * @create: 2022-08-18 22:01
 **/
@WebFilter("")//设置为不拦截
public class LoginSRFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("进入到未登录不能访问静态资源的过滤器"+req.getRequestURI());
        //不用登录 就能访问的资源
        String[] str = new String[]{"/login","login.jsp",".css",".js",".png",".jpg",".mp4"};
        //判定这个请求会否以上诉的资源访问
        //定义一个标志-请求是否是以上后缀结尾
        boolean flag = false;
        for (String url_suffix:str){
            if(req.getRequestURI().endsWith(url_suffix)){
                //放行
                flag=true;
            }
            //判定是否放行
            if(flag) {
                filterChain.doFilter(servletRequest,servletResponse);

            }else {
                //判定是否登录
                Object userInfo = req.getSession().getAttribute("userInfo");
                if(userInfo==null){
                    //说明没有登陆过
                    //进行跳转
                req.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
                }else {
                    //放行
                }
            }
        }

    }

    @Override
    public void destroy() {

    }
}
