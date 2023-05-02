package com.yanqingshan.admin.common.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname BaseEntity
 * @Description Entity基类
 * @Version 1.0.0
 * @Date 2023/4/30 19:15
 * @Created by yanqs
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
