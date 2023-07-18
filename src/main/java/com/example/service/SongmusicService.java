package com.example.service;

import com.example.entity.Songmusic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Songsheet;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhui
 * @since 2022-04-10
 */
public interface SongmusicService extends IService<Songmusic> {
    List<Songmusic> Select(Integer idsongsheet);

    boolean Add(Songmusic songmusic);

    boolean Del(Songmusic songmusic);

//    boolean Update(Songsheet songsheet);

}
