package com.zjj.seckill.domain.constants;

/**
 * 常量
 *
 * @author zhujunjian
 */
public class SeckillConstants {

    /**
     * 获取Key
     */
    public static String getKey(String prefix, String key) {
        return prefix.concat(key);
    }

    /**
     * token的载荷中存放的信息 只存放一个userId
     */
    public static final String TOKEN_CLAIM_USER_ID = "token_claim_userId";

}
