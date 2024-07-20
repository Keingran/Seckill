package com.zjj.seckill.domain.response;

import com.zjj.seckill.domain.code.HttpCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * 统一返回model
 *
 * @author zhujunjian
 */
public class Result extends HashMap<String, Object> implements Serializable {

    /**
     * 状态码
     */
    public static final String CODE = "code";

    /**
     * 提示信息
     */
    public static final String MSG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA = "data";


    /**
     * 返回结果为 状态码 + 提示信息
     *
     * @param code 状态码
     * @param msg  提示信息
     */
    public Result(int code, String msg) {
        super.put(CODE, code);
        super.put(MSG, msg);
    }

    /**
     * 返回结果为 状态码 + 提示信息 + 数据对象
     *
     * @param code 状态码
     * @param msg  提示信息
     * @param data 数据对象
     */
    public Result(int code, String msg, Object data) {
        super.put(CODE, code);
        super.put(MSG, msg);
        if (data != null) {
            super.put(DATA, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static Result success() {
        return Result.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static Result success(Object data) {
        return Result.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 提示信息
     * @return 成功消息
     */
    public static Result success(String msg) {
        return Result.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  提示信息
     * @param data 数据对象
     * @return 成功消息
     */
    public static Result success(String msg, Object data) {
        return new Result(HttpCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return 警告消息
     */
    public static Result fail() {
        return Result.fail("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Result fail(String msg) {
        return Result.fail(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  提示信息
     * @param data 数据对象
     * @return 警告消息
     */
    public static Result fail(String msg, Object data) {
        return new Result(HttpCode.FAILURE.getCode(), msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  提示信息
     * @return 警告消息
     */
    public static Result fail(int code, String msg) {
        return new Result(code, msg, null);
    }

}