package com.yanqingshan.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author yanqs
 * @date 2023年04月23日 14:07
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        //registry.addInterceptor(loginInterceptor)
        //        .addPathPatterns("/**") // 拦截所有请求
        //        .excludePathPatterns("/user/login") // 排除不拦截的 url
                //.excludePathPatterns("/**/*.html")
                //.excludePathPatterns("/**/*.js")
                //.excludePathPatterns("/**/*.css")
        //        .excludePathPatterns("/user/reg"); // 排除不拦截的 url
    }
}
