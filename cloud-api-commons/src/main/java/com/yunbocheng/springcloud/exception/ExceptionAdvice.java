package com.yunbocheng.springcloud.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.yunbocheng.springcloud.entities.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-01
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R exceptionHandle(MethodArgumentNotValidException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return R.error(e.getMessage());
    }

    @ExceptionHandler(AppException.class)
    public R exceptionHandle(AppException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHandle(Exception e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return R.error("服务器错误");
    }

}
