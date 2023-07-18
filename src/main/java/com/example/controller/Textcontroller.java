package com.example.controller;

import com.example.common.lang.Result;
import com.example.service.AllmusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Textcontroller {

    @Autowired
    AllmusicService allmusicservice;

    @GetMapping("/test")
    public Result test(){
        return Result.succ(allmusicservice.list());
    }
}
