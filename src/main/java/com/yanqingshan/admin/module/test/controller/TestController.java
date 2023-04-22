package com.yanqingshan.admin.module.test.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author yanqs
 * @date 2023年04月21日 18:37
 */
@Api(tags = "测试接口")
@ApiSupport(order = 1)
@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "输出文字")
    @GetMapping(value = "/say")
    public String say() {
        return "Hello SpringBoot Startup";
    }
}
