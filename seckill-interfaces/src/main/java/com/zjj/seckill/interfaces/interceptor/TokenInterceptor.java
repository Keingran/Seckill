package com.zjj.seckill.interfaces.interceptor;

import com.zjj.seckill.application.manager.TokenManager;
import com.zjj.seckill.domain.code.HttpCode;
import com.zjj.seckill.domain.dto.SeckillLoginUserDTO;
import com.zjj.seckill.domain.exception.SeckillException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器，登录授权拦截验证
 *
 * @author zhujunjian
 */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    // 自定义Token标识
    @Value("${token.header}")
    private String header;

    @Autowired
    private TokenManager tokenManager;

    /**
     * 执行前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        try {
            // 从请求头中获取Token
            String token = request.getHeader(header);
            if (StringUtils.isEmpty(token)) {
                throw new SeckillException(HttpCode.USER_NOT_LOGIN);
            }

            // 通过Token获取用户
            SeckillLoginUserDTO loginUser = tokenManager.getLoginUser(request);
            if (loginUser == null) {
                throw new SeckillException(HttpCode.USER_NOT_LOGIN);
            }

            tokenManager.verifyToken(loginUser);
            return true;
//        } catch (SeckillException e) {
//            throw new SeckillException(e.getCode(), e.getMessage());
//        } catch (Exception e) {
//            log.error("TokenInterceptor error", e);
//        }
//        return false;
    }

    /**
     * 执行中
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 执行后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
