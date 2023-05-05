package com.yanqingshan.admin.module.test.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.yanqingshan.admin.common.constant.AppConstant;
import com.yanqingshan.admin.common.core.domain.R;
import com.yanqingshan.admin.module.test.model.domain.Student;
import com.yanqingshan.admin.module.test.model.dto.StudentParam;
import com.yanqingshan.admin.module.test.model.dto.TestParam;
import com.yanqingshan.admin.module.test.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 测试控制器
 *
 * @author yanqs
 * @date 2023年04月21日 18:37
 */
@Api(tags = "测试接口")
@ApiSupport(order = 1)
@RestController
@RequestMapping(AppConstant.APPLICATION_TEST)
public class TestController {
    @Resource
    private StudentService studentService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "输出文字")
    @GetMapping(value = "/say")
    public R say() {
        return R.ok("Hello SpringBoot Startup");
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "异常情况")
    @GetMapping(value = "/error")
    public R error() {
        Object obj = null;
        int i = obj.hashCode();
        return R.ok();
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "验证请求参数")
    @PostMapping("/verify-user")
    public R testVerify(@Valid @RequestBody TestParam request) {
        return R.ok("用户“" + request.getUsername() + "”验证通过");
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "学生列表")
    @GetMapping(value = "/student/list")
    public R<List<Student>> list() {
        return R.ok(studentService.list());
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "添加学生")
    @PostMapping("/student/add")
    public R add(@Valid @RequestBody StudentParam request) {
        Student student = new Student();
        BeanUtil.copyProperties(request, student);
        return R.ok(studentService.save(student));
    }
}
