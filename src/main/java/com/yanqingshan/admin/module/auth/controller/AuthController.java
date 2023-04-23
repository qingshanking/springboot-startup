package com.yanqingshan.admin.module.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.util.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证控制器
 *
 * @Classname AuthController
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/4/23 21:13
 * @Created by yanqs
 */
@Api(tags = "认证模块")
@ApiSupport(order = 1)
@RestController
public class AuthController {
    // 测试登录
    @PostMapping("login")
    public R<SaTokenInfo> login() {
        StpUtil.login(10001);
        return R.ok(StpUtil.getTokenInfo());
    }

    // 查询登录状态
    @PostMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 测试注销
    @PostMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
}
