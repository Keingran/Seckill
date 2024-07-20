package com.zjj.seckill.application.manager;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zjj.seckill.domain.constants.RedisCacheConstants;
import com.zjj.seckill.domain.constants.SeckillConstants;
import com.zjj.seckill.domain.dto.SeckillLoginUserDTO;
import com.zjj.seckill.domain.model.SeckillUser;
import com.zjj.seckill.infrastructure.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Token管理
 *
 * @author zhujunjian
 */
@Component
public class TokenManager {

    // 自定义Token标识
    @Value("${token.header}")
    private String header;

    // Token秘钥
    @Value("${token.secret}")
    private String secret;

    // Token有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    /**
     * 1000ms = 1s
     */
    private static final Long MILLIS_SECOND = 1000L;

    /**
     * 60 * 1000ms = 1min
     */
    private static final Long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    /**
     * Token自动刷新时间
     */
    private static final Long TOKEN_AUTO_REFRESH_TIME = 20 * MILLIS_MINUTE;

    @Autowired
    private RedisManager redisManager;

    /**
     * 创建Token
     *
     * @param seckillUser 用户信息
     * @return Token
     */
    public String createToken(SeckillUser seckillUser) {
        SeckillLoginUserDTO loginUser = new SeckillLoginUserDTO();
        loginUser.setId(seckillUser.getId());
        loginUser.setUser(seckillUser);
        refreshToken(loginUser);
        return createToken(seckillUser.getId());
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public SeckillLoginUserDTO getLoginUser(HttpServletRequest request) {
        // 获取请求携带的Token
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            // 解析Token
            DecodedJWT decodedJWT = parseToken(token);
            if (decodedJWT == null) {
                return null;
            }
            // 获取Token中的userId
            Long userId = decodedJWT.getClaim(SeckillConstants.TOKEN_CLAIM_USER_ID).asLong();
            if (userId == null) {
                return null;
            }
            String userKey = getTokenKey(userId);
            return redisManager.getCacheObject(userKey);
        }
        return null;
    }

    /**
     * 刷新Token有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(SeckillLoginUserDTO loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        // Token有效期，30min
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据userId将loginUser缓存
        String userKey = getTokenKey(loginUser.getId());
        redisManager.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 获取请求token
     *
     * @return token
     */
    public String getToken(HttpServletRequest request) {
        // 获取请求携带的Token
        return request.getHeader(header);
    }

    /**
     * 生成userId Token
     *
     * @param userId userId
     * @return token
     */
    public String createToken(Long userId) {
        return JwtUtils.sign(userId, secret);
    }

    /**
     * 从数据声明生成Token
     *
     * @param claims 数据声明
     * @return Token
     */
    public String createToken(Map<String, Object> claims) {
        return JwtUtils.sign(claims, secret);
    }

    /**
     * 解析Token
     *
     * @param token Token
     * @return DecodedJWT
     */
    private DecodedJWT parseToken(String token) {
        return JwtUtils.parse(token);
    }

    /**
     * 验证Token有效期
     *
     * @param token token
     * @return true/false
     */
    public Boolean verifyToken(String token) {
        return JwtUtils.verify(token, secret);
    }

    /**
     * 验证Token有效期，如果相差不足20分钟，自动刷新缓存
     */
    public Boolean verifyToken(SeckillLoginUserDTO loginUser) {
        boolean verify = JwtUtils.verify(loginUser.getToken(), secret);
        if (!verify) {
            return false;
        }

        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= TOKEN_AUTO_REFRESH_TIME) {
            refreshToken(loginUser);
        }
        return true;
    }


    /**
     * Token Key
     *
     * @param userId userId
     * @return TokenKey
     */
    private String getTokenKey(Long userId) {
        return RedisCacheConstants.LOGIN_TOKEN_KEY + userId;
    }
}
