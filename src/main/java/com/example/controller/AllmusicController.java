package com.example.controller;


import com.example.common.lang.Result;
import com.example.service.AllmusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@RestController

public class AllmusicController extends BaseController {
    @Autowired
    AllmusicService allmusicservice;

    @GetMapping("/allmusic")
    public Result test(){
        return Result.succ(allmusicservice.list());
    }
}
