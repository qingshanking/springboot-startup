package com.yanqingshan.admin.module.test.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.module.test.model.domain.Student;
import com.yanqingshan.admin.module.test.model.dto.StudentRequest;
import com.yanqingshan.admin.module.test.service.StudentService;
import com.yanqingshan.admin.common.core.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Classname StudentController
 * @Description 测试：学生接口
 * @Version 1.0.0
 * @Date 2023/4/27 22:32
 * @Created by yanqs
 */
@Api(tags = "学生测试接口")
@ApiSupport(order = 2)
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "学生列表")
    @GetMapping(value = "/list")
    public R<List<Student>> list() {
        return R.ok(studentService.list());
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "添加学生")
    @PostMapping("/add")
    public R add(@Valid @RequestBody StudentRequest request) {
        Student student = new Student();
        BeanUtil.copyProperties(request,student);
        return R.ok(studentService.save(student));
    }
}
