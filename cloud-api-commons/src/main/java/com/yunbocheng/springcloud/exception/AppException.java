package com.yunbocheng.springcloud.exception;

import com.yunbocheng.springcloud.enums.ResultEnum;
import lombok.Getter;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-01
 */
@Getter
public class AppException extends RuntimeException{

    private final Integer code;

    private final String message;

    public AppException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.message = resultEnum.getMessage();
        this.code = resultEnum.getCode();
    }

    public AppException(String message) {
        super(message);
        this.message = message;
        this.code = 500;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
