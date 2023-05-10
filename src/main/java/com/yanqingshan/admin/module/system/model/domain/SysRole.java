package com.yanqingshan.admin.module.system.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yanqingshan.admin.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 角色表
 *
 * @author yanqs
 * @date 2023-05-10
 */
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @NotNull(message = "角色名不能为空")
    @TableField("role_name")
    private String roleName;

    /**
     * 角色别名
     */
    @NotNull(message = "角色别名不能为空")
    @TableField("role_alias")
    private String roleAlias;
}
