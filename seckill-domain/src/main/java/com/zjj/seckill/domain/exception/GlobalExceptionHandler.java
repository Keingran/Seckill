package com.zjj.seckill.domain.exception;

import com.zjj.seckill.domain.code.HttpCode;
import com.zjj.seckill.domain.response.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局统一异常处理器
 *
 * @author zhujunjian
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        logger.error("服务器异常", e);
        return Result.fail(HttpCode.SERVER_EXCEPTION.getCode(), e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(SeckillException.class)
    public Result seckillException(SeckillException e) {
        logger.error("业务异常", e);
        return Result.fail(e.getCode(), e.getMessage());
    }


}
