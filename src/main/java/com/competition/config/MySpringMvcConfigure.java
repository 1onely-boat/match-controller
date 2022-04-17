package com.competition.config;

import com.competition.component.MyLocaleResolver;
import com.competition.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Des MySpringMvcConfigure
 * @Author guyu
 * @Date 2020/7/11 22:34
 * @Param
 * @Return
 */
@Configuration
public class MySpringMvcConfigure {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        //指定拦截请求，/**表示拦截所有请求
                        .addPathPatterns("/**")
                        //不拦截以下路径
                        //  .excludePathPatterns("/","/manager.html","teacher.html","/index.html","/login")
                        .excludePathPatterns("/", "/index.html", "/login")
                        .excludePathPatterns("/css/*", "/img/*", "/js/*");

            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // registry.addViewController("/").setViewName("main/login");
                // registry.addViewController("index.html").setViewName("main/login");
                // registry.addViewController("main.html").setViewName("main/index");

                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("index.html").setViewName("main/login");
                //跳转到教师端
                registry.addViewController("teacher.html").setViewName("teacher/index");
                //跳转到管理员端
                registry.addViewController("manager.html").setViewName("manager/index");
            }
        };
    }

    //将区域解析器加载到容器

    @Bean
    public LocaleResolver localeResolver() {
        // System.out.println("加载--》 MyLocaleResolver");
        return new MyLocaleResolver();
    }


}
