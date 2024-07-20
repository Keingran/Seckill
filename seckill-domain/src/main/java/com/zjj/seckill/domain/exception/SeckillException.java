package com.zjj.seckill.domain.exception;

import com.zjj.seckill.domain.code.HttpCode;

/**
 * 自定义异常
 *
 * @author zhujunjian
 */
public class SeckillException extends RuntimeException {

    /**
     * code
     */
    private Integer code;

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(HttpCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public SeckillException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
