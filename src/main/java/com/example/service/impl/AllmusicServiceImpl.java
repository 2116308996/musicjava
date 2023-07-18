package com.example.service.impl;

import com.example.entity.Allmusic;
import com.example.mapper.AllmusicMapper;
import com.example.service.AllmusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@Service
public class AllmusicServiceImpl extends ServiceImpl<AllmusicMapper, Allmusic> implements AllmusicService {

    @Autowired
    AllmusicMapper allmusicMapper;

    @Override
    public Allmusic Select(Integer idallmusic) {
        Allmusic i=allmusicMapper.select(idallmusic);
        return i;
    }
}
