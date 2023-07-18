package com.example.service.impl;

import com.example.entity.Songmusic;
import com.example.mapper.SongmusicMapper;
import com.example.service.SongmusicService;
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
 * @since 2022-04-10
 */
@Service
public class SongmusicServiceImpl extends ServiceImpl<SongmusicMapper, Songmusic> implements SongmusicService {
    @Autowired
    private SongmusicMapper songmusicMapper;

    @Override
    public List<Songmusic> Select(Integer idsongsheet) {
        List<Songmusic> i=songmusicMapper.select(idsongsheet);
        return i;
    }

    @Override
    public boolean Add(Songmusic songmusic) {
        int i=songmusicMapper.insert(songmusic);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean Del(Songmusic songmusic) {
        int i=songmusicMapper.delete(songmusic);
        if(i>0)
            return true;
        else
            return false;
    }
}
