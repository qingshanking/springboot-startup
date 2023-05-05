package com.yanqingshan.admin.module.system.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author yanqs
 * @date 2023年05月05日 16:08
 */
@ApiModel("用户请求参数 Request VO")
@Data
@ToString(callSuper = true)
public class SysUserParam implements java.io.Serializable {

    private Long id;

    @ApiModelProperty(value = "账户")
    private String userName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    private String sex;

    private String email;

    private String avatar;

    private String phone;

    /**
     * 前端Md5加密后再上传
     */
    private String password;
}
