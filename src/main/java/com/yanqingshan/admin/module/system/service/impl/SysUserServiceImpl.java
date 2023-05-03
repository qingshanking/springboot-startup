package com.yanqingshan.admin.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanqingshan.admin.module.system.mapper.SysUserMapper;
import com.yanqingshan.admin.module.system.model.domain.SysUser;
import com.yanqingshan.admin.module.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Classname SysUserServiceImpl
 * @Description 系统用户 Service业务层处理
 * @Version 1.0.0
 * @Date 2023/5/3 17:31
 * @Created by yanqs
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {
    /**
     * 根据登录账号获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public SysUser login(String username) {
        return getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, username));
    }
}
