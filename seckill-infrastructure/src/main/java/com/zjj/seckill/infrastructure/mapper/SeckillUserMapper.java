package com.zjj.seckill.infrastructure.mapper;

import com.zjj.seckill.domain.model.SeckillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户mapper
 *
 * @author zhujunjian
 */
@Mapper
public interface SeckillUserMapper {

    /**
     * 新增
     */
    int insert(SeckillUser seckillUser);

    /**
     * 根据用户名获取用户信息
     *
     * @param userName userName
     * @return SeckillUser
     */
    SeckillUser getSeckillUserByUserName(@Param("userName") String userName);

}