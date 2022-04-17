package com.competition.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Des DruidConfig
 * @Author guyu
 * @Date 2020/7/11 22:33
 * @Param
 * @Return
 */

@Configuration

public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    /*
     * 配置druid监控
     *
     **/
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //StatViewServlet 用来配置后台的servlet
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //传入key，value
        // 添加IP白名单 默认访问所有ip
        //bean.addInitParameter("allow","");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        bean.addInitParameter("deny","192.168.10.1");
        // 添加控制台管理用户
        bean.addInitParameter("loginUsername","root");
        bean.addInitParameter("loginPassword","123");
        // 是否能够重置数据
        bean.addInitParameter("resetEnable","false");

        //下面一种方法传入的是map，和上面的效果实现方式是一样的
        /*

        Map<String, String> initParam = new HashMap<>();
        //访问的用户名密码
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD, "123456");
        //允许访问的ip，默认所有ip访问
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        //禁止访问的ip
        initParam.put(StatViewServlet.PARAM_NAME_DENY, "192.168.10.1");
        bean.setInitParameters(initParam);
        bean.setInitParameters();

        */
        return bean;

    }
    /*
     * 配置过滤器
     * */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //配置初始化参数
        Map<String, String> initParam = new HashMap<>();

        initParam.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        //拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;


    }
}

