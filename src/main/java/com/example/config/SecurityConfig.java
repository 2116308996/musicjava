//package com.example.config;
//
//import com.example.security.CaptchaFilter;
//import com.example.security.LoginCuccessHandler;
//import com.example.security.LoginFailureHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    LoginFailureHandler loginFailureHandler;
//
//    @Autowired
//    LoginCuccessHandler loginCuccessHandler;
//
////    @Autowired
////    CaptchaFilter captchaFilter;
//
//    private static final String[] URL_WHITELIST={
//            "/login",
//            "/logout",
//            "/captcha",
//            "/favicon.ico",
//
//    };
//
//    protected void configure(HttpSecurity http) throws Exception{
//
//        http.cors().and().csrf().disable()
//
//
//
//                //登录配置
//        .formLogin()
//                .successHandler(loginCuccessHandler)
//                .failureHandler(loginFailureHandler)
//
//               //禁用session
//        .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//              //配置拦截规则
//        .and()
//                .authorizeRequests()
//                .antMatchers(URL_WHITELIST).permitAll()
//                .anyRequest().authenticated()
//
//             //异常处理器
//
//             //配置自定义的过滤器
//        .and()
//       // .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
//         ;
//    }
//}
