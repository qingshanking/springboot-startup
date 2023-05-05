package com.yanqingshan.admin.common.utils;

import cn.hutool.crypto.SecureUtil;

/**
 * @author yanqs
 * @date 2023年05月05日 16:25
 */
public class UserPasswordUtil {
    /**
     * 生成密码
     * <p>
     * 账户密码加密规则：sha1(md5(密码值)+md5(密码))
     *
     * @param pwdKey   密码值(创建用户随机生成)
     * @param password 密码(md5加密)
     * @return
     */
    public static String passwordGenerated(String pwdKey, String password) {
        return SecureUtil.sha1(SecureUtil.md5(pwdKey) + SecureUtil.md5(password));
    }
}
