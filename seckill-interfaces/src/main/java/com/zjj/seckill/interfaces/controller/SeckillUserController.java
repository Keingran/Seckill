package com.zjj.seckill.interfaces.controller;

import com.zjj.seckill.application.service.SeckillUserService;
import com.zjj.seckill.domain.code.ErrorCode;
import com.zjj.seckill.domain.model.SeckillUser;
import com.zjj.seckill.domain.response.ResponseMessage;
import com.zjj.seckill.domain.response.ResponseMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户 Controller
 *
 * @author zhujunjian
 */
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class SeckillUserController {

    @Autowired
    private SeckillUserService seckillUserService;

    /**
     * 测试系统
     */
    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<SeckillUser> getUser(@RequestParam(value = "username") String userName) {
        return ResponseMessageBuilder.build(ErrorCode.SUCCESS.getCode(), seckillUserService.getSeckillUserByUserName(userName));
    }
}