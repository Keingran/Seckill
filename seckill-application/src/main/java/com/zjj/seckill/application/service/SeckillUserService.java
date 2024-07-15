package com.zjj.seckill.application.service;

import com.zjj.seckill.domain.model.SeckillUser;

/**
 * 用户服务
 *
 * @author zhujunjian
 */
public interface SeckillUserService {

    /**
     * 根据用户名获取用户信息
     */
    SeckillUser getSeckillUserByUserName(String userName);
}