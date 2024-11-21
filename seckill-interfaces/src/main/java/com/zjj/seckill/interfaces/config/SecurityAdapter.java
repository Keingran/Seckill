package com.zjj.seckill.interfaces.config;

import com.zjj.seckill.interfaces.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 安全适配器
 *
 * @author zhujunjian
 */
@Configuration
public class SecurityAdapter implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                // token拦截器
                .addInterceptor(tokenInterceptor)
                // 所有的请求都要拦截
                .addPathPatterns("/**")
                // 对于登录login，允许匿名访问
                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/error")
                .excludePathPatterns("/favicon.ico")
        ;
    }
}