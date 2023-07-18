package com.example.service;

import com.example.entity.Allmusic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
public interface AllmusicService extends IService<Allmusic> {
    Allmusic Select(Integer idallmusic);

}
