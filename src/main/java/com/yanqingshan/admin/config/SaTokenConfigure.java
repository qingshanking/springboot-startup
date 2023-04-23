package com.yanqingshan.admin.config;

import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname SaTokenConfigure
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/4/23 21:12
 * @Created by yanqs
 */
@Configuration
public class SaTokenConfigure {
    // Sa-Token 整合 jwt (Simple 简单模式)
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }
}
