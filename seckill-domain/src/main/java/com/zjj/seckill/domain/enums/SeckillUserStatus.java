package com.zjj.seckill.domain.enums;

/**
 * 用户状态枚举
 *
 * @author zhujunjian
 */
public enum SeckillUserStatus {

    /**
     * 正常
     */
    NORMAL(1),

    /**
     * 冻结
     */
    FREEZE(2);

    private final Integer code;

    SeckillUserStatus(Integer code) {
        this.code = code;
    }

    public static boolean isNormal(Integer status) {
        return NORMAL.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}