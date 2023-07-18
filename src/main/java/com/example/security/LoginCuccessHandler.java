//package com.example.security;
//
//import cn.hutool.json.JSONUtil;
//import com.example.common.lang.Result;
//import com.example.utils.JwtUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Component
//public class LoginCuccessHandler implements AuthenticationSuccessHandler {
//
//    @Autowired
//    JwtUtils jwtUtils;
//
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws ServletException,IOException {
//        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        ServletOutputStream outputStream=httpServletResponse.getOutputStream();
//
//        //生成jwt，兵放置到请求头中
//        String jwt=jwtUtils.generateToken(authentication.getName());
//        httpServletResponse.setHeader(jwtUtils.getHeader(),jwt);
//
//        Result result=Result.succ("");
//
//        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
//
//        outputStream.flush();
//        outputStream.close();
//    }
//}
