package com.yanqingshan.admin.module.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.common.constant.AppConstant;
import com.yanqingshan.admin.common.core.domain.R;
import com.yanqingshan.admin.module.system.model.domain.SysRole;
import com.yanqingshan.admin.module.system.model.dto.SysRoleParam;
import com.yanqingshan.admin.module.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 角色管理 前端控制器
 *
 * @author yanqs
 * @date 2023-05-10
 */
@Api(tags = "角色模块")
@ApiSupport(order = 4)
@RestController
@RequestMapping(AppConstant.APPLICATION_SYSTEM + "/role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @ApiOperationSupport(order = 1)
    @ApiOperation("创建角色")
    @PostMapping("/create")
    public R create(@Valid @RequestBody SysRoleParam param) {
        SysRole data = BeanUtil.copyProperties(param, SysRole.class);
        return sysRoleService.create(data);
    }

}
