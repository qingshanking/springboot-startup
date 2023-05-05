package com.yanqingshan.admin.module.system.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yanqingshan.admin.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * @Classname SysUser
 * @Description 系统用户类
 * @Version 1.0.0
 * @Date 2023/4/30 19:13
 * @Created by yanqs
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户
     */
    @TableField("user_name")
    private String userName;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

}
