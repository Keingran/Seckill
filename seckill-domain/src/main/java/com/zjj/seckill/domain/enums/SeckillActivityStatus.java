package com.zjj.seckill.domain.enums;

/**
 * 活动状态枚举
 *
 * @author zhujunjian
 */
public enum SeckillActivityStatus {

    /**
     * 发布
     */
    PUBLISHED(0),

    /**
     * 上线
     */
    ONLINE(1),

    /**
     * 下线
     */
    OFFLINE(-1);


    private final Integer code;

    SeckillActivityStatus(Integer code) {
        this.code = code;
    }

    public static boolean isOffline(Integer status) {
        return OFFLINE.getCode().equals(status);
    }

    public static boolean isOnline(Integer status) {
        return ONLINE.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}