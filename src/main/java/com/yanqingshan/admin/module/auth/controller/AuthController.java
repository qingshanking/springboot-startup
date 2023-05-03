package com.yanqingshan.admin.module.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.common.core.domain.R;
import com.yanqingshan.admin.module.auth.model.dto.LoginUserRequestVO;
import com.yanqingshan.admin.module.system.model.domain.SysUser;
import com.yanqingshan.admin.module.system.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

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

    @Resource
    private SysUserService sysUserService;
    // 测试登录
    @PostMapping("login")
    public R<SaTokenInfo> login(@Valid @RequestBody LoginUserRequestVO request) {
        SysUser user = sysUserService.login(request.getUsername());
        if(Objects.isNull(user)){
            return R.failed("账号不存在或密码错误");
        }
        StpUtil.login(user.getId());
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
