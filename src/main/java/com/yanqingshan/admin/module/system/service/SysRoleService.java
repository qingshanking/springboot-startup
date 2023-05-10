package com.yanqingshan.admin.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanqingshan.admin.common.core.domain.R;
import com.yanqingshan.admin.module.system.model.domain.SysRole;

/**
 * 系统角色 Service接口
 *
 * @author yanqs
 * @date 2023-05-10
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 新增角色
     *
     * @param role
     * @return boolean
     */
    R create(SysRole role);
}
