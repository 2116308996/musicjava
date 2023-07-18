package com.example.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.example.common.lang.Const;
import com.example.common.lang.Result;

import com.example.service.AllmusicService;
import com.example.service.UserService;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Base64;


@Slf4j
@RestController
public class AutoController extends BaseController{
    @Autowired
    Producer producer;

    @Autowired
    AllmusicService allmusicservice;

    @Autowired
    UserService userService;

    /**
     * 图片验证码
     */
    @GetMapping("/captcha")
    public Result captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = producer.createText();
        String key = UUID.randomUUID().toString();



        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        Base64.Encoder encoder = Base64.getEncoder();

        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encodeToString(outputStream.toByteArray());

        // 存储到redis中
        redisUtil.hset(Const.CAPTCHA_KEY, key, code,120);
        log.info("验证码 -- {} - {}", key, code);
        return Result.succ(
                MapUtil.builder()
                        .put("token", key)
                        .put("code",code)
                        .put("base64Img", base64Img)
                        .build()
        );
    }
//
//    @GetMapping("/userinfo")
//    public Result userinfo(){
//
//        return Result.succ(userService.list());
//    }
//
//    @GetMapping("/allmusic")
//    public Result allmusic(){
//
//        return Result.succ(allmusicservice.list());
//    }
//
//    @GetMapping("/adduser{username}")
//    public Result adduser(){
//
//        return Result.succ(allmusicservice.list());
//    }
}
