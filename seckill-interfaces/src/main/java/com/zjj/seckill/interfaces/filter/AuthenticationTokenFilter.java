//package com.zjj.seckill.interfaces.filter;
//
//import com.zjj.seckill.application.manager.TokenManager;
//import com.zjj.seckill.domain.dto.SeckillLoginUserDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * token过滤器 验证token有效性
// */
//@Component
//@Slf4j
//public class AuthenticationTokenFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenManager tokenManager;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        // 从Request中获取Token
//        SeckillLoginUserDTO loginUser = tokenManager.getLoginUser(request);
//        if (loginUser != null) {
//            tokenManager.verifyToken(loginUser);
//        }
//        chain.doFilter(request, response);
//    }
//}
