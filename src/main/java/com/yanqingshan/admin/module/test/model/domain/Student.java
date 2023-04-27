package com.yanqingshan.admin.module.test.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Student
 * @Description 测试：学生表
 * @Version 1.0.0
 * @Date 2023/4/27 22:19
 * @Created by yanqs
 */
@Data
@TableName("student")
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private Integer sex;

    @TableField("age")
    private Integer age;
}
