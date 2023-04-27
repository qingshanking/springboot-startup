package com.yanqingshan.admin.module.test.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.module.test.model.dto.TestRequest;
import com.yanqingshan.admin.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public R say() {
        return R.ok("Hello SpringBoot Startup");
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "异常情况")
    @GetMapping(value = "/error")
    public R error() {
        Object obj = null;
        int i = obj.hashCode();
        return R.ok();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "验证请求参数")
    @PostMapping("/verify-user")
    public R testVerify(@Valid @RequestBody TestRequest request) {
        return R.ok("用户“"+request.getUsername()+"”验证通过");
    }
}
