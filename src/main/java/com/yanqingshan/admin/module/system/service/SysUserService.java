package com.yanqingshan.admin.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanqingshan.admin.module.system.model.domain.SysUser;

/**
 * @Classname SysUserService
 * @Description 系统用户 Service接口
 * @Version 1.0.0
 * @Date 2023/5/3 17:31
 * @Created by yanqs
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据登录账号获取用户信息
     *
     * @param username
     * @return
     */
    SysUser login(String username);
}
