package com.competition.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Des 定义登录拦截器
 * @Author guyu
 * @Date 2020/7/11 22:53
 * @Param
 * @Return
 */


public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object usr = request.getSession().getAttribute("loginUser");
        if (usr!=null){
            return true;
        }
        //没有登录
        request.setAttribute("msg","请先登录");
        //转发到 拦截器的index.html
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
