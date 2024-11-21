package com.zjj.seckill.interfaces.controller;

import com.zjj.seckill.application.service.SeckillUserService;
import com.zjj.seckill.domain.dto.SeckillUserDTO;
import com.zjj.seckill.domain.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 Controller
 *
 * @author zhujunjian
 */
@RestController
@RequestMapping(value = "/user")
public class SeckillUserController {

    @Autowired
    private SeckillUserService seckillUserService;

    /**
     * 测试系统
     */
    @RequestMapping(value = "/test")
    public Result getUser(@RequestParam(value = "username") String userName) {
        return Result.success(seckillUserService.getSeckillUserByUserName(userName));
    }

    /**
     * 测试系统
     */
    @RequestMapping(value = "/getByUserId")
    public Result getByUserId(@RequestParam(value = "userId") Long userId) {
        return Result.success(seckillUserService.getSeckillUserByUserId(userId));
    }

    @RequestMapping(value = "/login")
    public Result login(@RequestBody SeckillUserDTO seckillUserDTO) {
        return Result.success(seckillUserService.login(seckillUserDTO.getUserName(), seckillUserDTO.getPassword()));
    }
}