package com.yanqingshan.admin.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanqingshan.admin.common.core.domain.R;
import com.yanqingshan.admin.module.system.mapper.SysRoleMapper;
import com.yanqingshan.admin.module.system.model.domain.SysRole;
import com.yanqingshan.admin.module.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 系统角色 Service业务层处理
 *
 * @author yanqs
 * @date 2023-05-10
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    /**
     * 新增角色
     *
     * @param role
     * @return boolean
     */
    @Override
    public R create(SysRole role) {
        //角色名称和别名必须唯一
        if (verifyUnique(role)) {
            if(save(role)){
                return R.ok();
            }
        }
        return R.failed("角色名称和别名必须唯一");
    }

    /**
     * 验证唯一
     *
     * @return boolean
     */
    private boolean verifyUnique(SysRole role) {
        LambdaQueryWrapper<SysRole> query = new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleName, role.getRoleName())
                .or(t -> t.eq(SysRole::getRoleAlias, role.getRoleAlias()));
        if (Objects.nonNull(role.getId())) {
            query.ne(SysRole::getId, role.getId());
        }
        List<SysRole> list = list(query);
        if (Objects.nonNull(list) && list.size() > 0) {
            return false;
        }
        return true;
    }
}
