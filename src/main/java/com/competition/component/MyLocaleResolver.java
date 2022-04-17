package com.competition.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Des 自定义区域解析器
 * @Author guyu
 * @Date 2020/7/11 22:31
 * @Param
 * @Return
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析区域信息
     */

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // System.out.println("区域信息。。。"); //获取请求头中的l参数值
        String l = httpServletRequest.getParameter("l"); //获取浏览器上的区域信息
        // Locale locale = httpServletRequest.getLocale(); //获取当前操作系统 默认的区域信息
        Locale locale = Locale.getDefault(); //获取当前操作系统 默认的区域信息

        //参数有区域信息，则用参数里的区域信息
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_"); //参数:语言代码，国家代码
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }


}
