package com.zjj.seckill.domain.response;

import java.io.Serializable;

/**
 * 统一返回model
 *
 * @author zhujunjian
 */
public class ResponseMessage<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * data
     */
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}