package com.yanqingshan.admin;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 * @author yanqs
 * @date 2023年04月21日 17:54
 */
@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
