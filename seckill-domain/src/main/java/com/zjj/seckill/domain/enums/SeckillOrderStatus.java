package com.zjj.seckill.domain.enums;

/**
 * 订单状态枚举
 *
 * @author zhujunjian
 */
public enum SeckillOrderStatus {

    /**
     * 已创建
     */
    CREATED(1),

    /**
     * 已支付
     */
    PAID(2),

    /**
     * 已取消
     */
    CANCELED(0),

    /**
     * 已删除
     */
    DELETED(-1);

    /**
     * 是否已取消
     *
     * @param status status
     * @return true/false
     */
    public static boolean isCanceled(Integer status) {
        return CANCELED.getCode().equals(status);
    }

    /**
     * 是否已删除
     *
     * @param status status
     * @return true/false
     */
    public static boolean isDeleted(Integer status) {
        return DELETED.getCode().equals(status);
    }

    private final Integer code;

    SeckillOrderStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}