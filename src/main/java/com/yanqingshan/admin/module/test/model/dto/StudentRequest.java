package com.yanqingshan.admin.module.test.model.dto;

import com.yanqingshan.admin.module.test.model.domain.Student;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Classname StudentRequest
 * @Description 学生请求参数
 * @Version 1.0.0
 * @Date 2023/4/27 22:43
 * @Created by yanqs
 */
@Data
public class StudentRequest {
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;
}
