package com.zjj.seckill.application.service.impl;

import com.zjj.seckill.application.manager.RedisManager;
import com.zjj.seckill.application.manager.TokenManager;
import com.zjj.seckill.application.service.SeckillUserService;
import com.zjj.seckill.domain.code.HttpCode;
import com.zjj.seckill.domain.constants.RedisCacheConstants;
import com.zjj.seckill.domain.exception.SeckillException;
import com.zjj.seckill.domain.model.SeckillUser;
import com.zjj.seckill.domain.repository.SeckillUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 用户服务
 *
 * @author zhujunjian
 */
@Service
public class SeckillUserServiceImpl implements SeckillUserService {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private RedisManager redisManager;

    @Autowired
    private SeckillUserRepository seckillUserRepository;

    @Override
    public SeckillUser getSeckillUserByUserId(Long userId) {
        return redisManager.getCacheObject(RedisCacheConstants.LOGIN_TOKEN_KEY + userId);
    }


    @Override
    public SeckillUser getSeckillUserByUserName(String userName) {
        return seckillUserRepository.getSeckillUserByUserName(userName);
    }

    @Override
    public String login(String userName, String password) {
        // 参数校验
        if (StringUtils.isBlank(userName)) {
            throw new SeckillException(HttpCode.USERNAME_IS_NULL);
        }
        if (StringUtils.isBlank(password)) {
            throw new SeckillException(HttpCode.PASSWORD_IS_NULL);
        }

        // 根据userName查询User
        SeckillUser seckillUser = seckillUserRepository.getSeckillUserByUserName(userName);
        if (seckillUser == null) {
            throw new SeckillException(HttpCode.USERNAME_IS_ERROR);
        }

        // 校验密码
        String encryptPassword = DigestUtils.md5DigestAsHex((password + seckillUser.getSalt()).getBytes());
        if (!encryptPassword.equals(seckillUser.getPassword())) {
            throw new SeckillException(HttpCode.PASSWORD_IS_ERROR);
        }

        // 返回token
        return tokenManager.createToken(seckillUser);
    }

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex(("123456" + "abc").getBytes()));
    }
}