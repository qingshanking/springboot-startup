package com.yanqingshan.admin.config;

import com.yanqingshan.admin.constant.enums.ServiceExceptionEnum;
import com.yanqingshan.admin.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 异常拦截器
 *
 * @author yanqs
 * @date 2023年04月23日 14:15
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionAdvice {

    /**
     * 处理 MissingServletRequestParameterException 异常
     * <p>
     * SpringMVC 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public R missingServletRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException ex) {
        log.error("[missingServletRequestParameterExceptionHandler]", ex);
        // 包装 CommonResult 结果
        return R.failed(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),null,
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public R constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException ex) {
        log.error("[constraintViolationExceptionHandler]", ex);
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(constraintViolation.getMessage());
        }
        // 包装 CommonResult 结果
        return R.failed(ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getCode(),null,
                ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getMessage() + ":" + detailMessage.toString());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public R bindExceptionHandler(HttpServletRequest req, BindException ex) {
        log.info("========进入了 bindException======");
        log.error("[bindExceptionHandler]", ex);
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ObjectError objectError : ex.getAllErrors()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(objectError.getDefaultMessage());
        }
        // 包装 CommonResult 结果
        return R.failed(ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getCode(),null,
                ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getMessage() + ":" + detailMessage.toString());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R MethodArgumentNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException ex) {
        log.info("-----------------进入了 MethodArgumentNotValidException-----------------");
        //log.error("[MethodArgumentNotValidException]", ex);
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(objectError.getDefaultMessage());
        }
        // 包装 CommonResult 结果
        return R.failed(ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getCode(),null,
                ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getMessage() + ":" + detailMessage.toString());
    }

    /**
     * 处理其它 Exception 异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R exceptionAdvice(Exception e) {
        return R.failed(null, "异常信息：" + e.getMessage());
    }

}
