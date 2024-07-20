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

    /**
     * 是否下线
     *
     * @param status status
     * @return true/false
     */
    public static boolean isOffline(Integer status) {
        return OFFLINE.getCode().equals(status);
    }

    /**
     * 是否上线
     *
     * @param status status
     * @return true/false
     */
    public static boolean isOnline(Integer status) {
        return ONLINE.getCode().equals(status);
    }

    /**
     * code
     */
    private final Integer code;

    SeckillActivityStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}