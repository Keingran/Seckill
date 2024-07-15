package com.zjj.seckill.domain.enums;

/**
 * 订单状态枚举
 *
 * @author zhujunjian
 */
public enum SeckillOrderStatus {
    /**
     * 以创建
     */
    CREATED(1),

    /**
     * 已支付
     */
    PAID(2),

    /**
     * 以取消
     */
    CANCELED(0),

    /**
     * 已删除
     */
    DELETED(-1);

    private final Integer code;

    SeckillOrderStatus(Integer code) {
        this.code = code;
    }

    public static boolean isCancled(Integer status) {
        return CANCELED.getCode().equals(status);
    }

    public static boolean isDeleted(Integer status) {
        return DELETED.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}