package com.zjj.seckill.application.service;

import com.zjj.seckill.domain.dto.SeckillUserDTO;
import com.zjj.seckill.domain.model.SeckillUser;

/**
 * 用户服务
 *
 * @author zhujunjian
 */
public interface SeckillUserService {

    /**
     * 新增
     */
    Long insert(SeckillUserDTO seckillUserDTO);

    /**
     * 根据用户id获取用户信息
     */
    SeckillUser getSeckillUserByUserId(Long userId);

    /**
     * 根据用户名获取用户信息
     */
    SeckillUser getSeckillUserByUserName(String userName);

    /**
     * 登录
     */
    String login(String userName, String password);

}