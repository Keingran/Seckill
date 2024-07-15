package com.zjj.seckill.domain.enums;

/**
 * 商品状态枚举
 *
 * @author zhujunjian
 */
public enum SeckillGoodsStatus {

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

    SeckillGoodsStatus(Integer code) {
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