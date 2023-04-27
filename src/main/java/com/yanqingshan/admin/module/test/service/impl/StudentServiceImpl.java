package com.yanqingshan.admin.module.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanqingshan.admin.module.test.mapper.StudentMapper;
import com.yanqingshan.admin.module.test.model.domain.Student;
import com.yanqingshan.admin.module.test.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Classname StudentServiceImpl
 * @Description 学生表 Service业务层处理
 * @Version 1.0.0
 * @Date 2023/4/27 22:30
 * @Created by yanqs
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
}
