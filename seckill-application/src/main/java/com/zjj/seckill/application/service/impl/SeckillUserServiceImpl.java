package com.zjj.seckill.application.service.impl;

import com.zjj.seckill.application.service.SeckillUserService;
import com.zjj.seckill.domain.model.SeckillUser;
import com.zjj.seckill.domain.repository.SeckillUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author zhujunjian
 */
@Service
public class SeckillUserServiceImpl implements SeckillUserService {

    @Autowired
    private SeckillUserRepository seckillUserRepository;

    @Override
    public SeckillUser getSeckillUserByUserName(String userName) {
        return seckillUserRepository.getSeckillUserByUserName(userName);
    }
}