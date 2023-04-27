package com.yanqingshan.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

    /**
     * 配置跨域问题
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            //重写父类提供的跨域请求处理的接口
            public void addCorsMappings(CorsRegistry registry) {
                //添加映射路径
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //放行哪些原始域(请求方式)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("*")
                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        .exposedHeaders("token");

            }
        };
    }


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
