package com.example.mapper;

import com.example.entity.Allmusic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@Mapper
@Component
public interface AllmusicMapper extends BaseMapper<Allmusic> {
    //查询歌曲信息
    Allmusic select(Integer idallmusic);


}
