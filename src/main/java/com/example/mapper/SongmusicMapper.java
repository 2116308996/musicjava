package com.example.mapper;

import com.example.entity.Songmusic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuhui
 * @since 2022-04-10
 */
@Mapper
@Component
public interface SongmusicMapper extends BaseMapper<Songmusic> {
    //添加歌曲
    int insert(Songmusic songmusic);
    //通过歌单名查询歌曲
    List<Songmusic> select(Integer idsongsheet);
//    //修改歌名
//    int update(Songsheet songsheet);
    //删除歌曲
    int delete(Songmusic songmusic);
}
