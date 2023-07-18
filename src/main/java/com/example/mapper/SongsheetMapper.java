package com.example.mapper;

import com.example.entity.Songsheet;
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
public interface SongsheetMapper extends BaseMapper<Songsheet> {
    //添加歌单
    int insert(Songsheet songsheet);
    //查询歌单
    List<Songsheet> select(Integer iduser);
    //修改歌单名
    int update(Songsheet songsheet);
    //删除歌单
    int delete(int idsongsheet);

}
