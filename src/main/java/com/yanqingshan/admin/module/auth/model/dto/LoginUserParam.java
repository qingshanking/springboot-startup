package com.yanqingshan.admin.module.auth.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @Classname LoginUserRequestVO
 * @Description 登录用户请求体
 * @Version 1.0.0
 * @Date 2023/5/3 20:34
 * @Created by yanqs
 */
@Data
public class LoginUserParam {
    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 4, max = 10, message = "账号长度为 4-10 位")
    //@Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 1000, message = "密码长度为 6-16 位")
    private String password;

}
