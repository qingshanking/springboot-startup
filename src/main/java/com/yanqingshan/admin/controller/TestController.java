package com.yanqingshan.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author yanqs
 * @date 2023年04月21日 18:37
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping(value = "/say")
    public String say() {
        return "Hello SpringBoot Startup";
    }
}
