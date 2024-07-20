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

    SeckillGoodsStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}