package com.yanqingshan.admin.config;

import com.yanqingshan.admin.util.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author yanqs
 * @date 2023年04月23日 14:15
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Object exceptionAdvice(Exception e) {
        return R.failed(null, "异常信息：" + e.getMessage());
    }


}
