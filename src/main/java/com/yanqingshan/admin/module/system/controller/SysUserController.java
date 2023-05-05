package com.yanqingshan.admin.module.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.common.constant.AppConstant;
import com.yanqingshan.admin.common.core.domain.R;
import com.yanqingshan.admin.common.utils.UserPasswordUtil;
import com.yanqingshan.admin.module.system.model.domain.SysUser;
import com.yanqingshan.admin.module.system.model.dto.SysUserParam;
import com.yanqingshan.admin.module.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * 系统用户 控制器
 *
 * @author yanqs
 * @date 2023年05月05日 16:04
 */
@Api(tags = "用户模块")
@ApiSupport(order = 1)
@RestController
@RequestMapping(AppConstant.APPLICATION_SYSTEM + "/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @ApiOperationSupport(order = 1)
    @ApiOperation("创建用户")
    @PostMapping("/create")
    public R create(@Valid @RequestBody SysUserParam param) {
        SysUser data = BeanUtil.copyProperties(param, SysUser.class);
        //log.debug("用户：{};原始密码：{}", param.getUserName(), param.getPassword());
        // 密码进行加密
        data.setPassword(UserPasswordUtil.passwordGenerated(data.getUserName(), param.getPassword()));
        //log.debug("加密后：{}", data.getPassword());
        return R.status(sysUserService.save(data));
    }

}
