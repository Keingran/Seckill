
package com.zjj.seckill.infrastructure.repository;

import com.zjj.seckill.domain.model.SeckillUser;
import com.zjj.seckill.domain.repository.SeckillUserRepository;
import com.zjj.seckill.infrastructure.mapper.SeckillUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户服务
 *
 * @author zhujunjian
 */
@Component
public class SeckillUserRepositoryImpl implements SeckillUserRepository {

    @Autowired
    private SeckillUserMapper seckillUserMapper;

    @Override
    public SeckillUser getSeckillUserByUserName(String userName) {
        return seckillUserMapper.getSeckillUserByUserName(userName);
    }
}