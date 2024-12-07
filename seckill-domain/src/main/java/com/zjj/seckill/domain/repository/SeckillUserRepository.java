package com.zjj.seckill.domain.repository;

import com.zjj.seckill.domain.model.SeckillUser;

/**
 * 用户服务
 *
 * @author zhujunjian
 */
public interface SeckillUserRepository {

    /**
     * 新增
     */
    int insert(SeckillUser seckillUser);

    /**
     * 根据用户名获取用户信息
     */
    SeckillUser getSeckillUserByUserName(String userName);

}